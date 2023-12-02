package Demchenko.computer.controllers;

import Demchenko.computer.services.ComputerService;
import Demchenko.computer.models.Computer;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Контроллер для работы с компьютерами
 */
@Controller
@RequestMapping("/")
public class ComputerController {

    /**
     * Логгер для вывода ошибок
     */
    private static final Logger logger = LoggerFactory.getLogger(ComputerController.class);

    private final ComputerService computerService;

    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    /**
     * Показывает список всех компьютеров
     * @param gpu  Параметр для фильтрации
     * @param model Модель для передачи данных в представление
     * @return Имя представления для отображения
     */
    @GetMapping("/")
    public String listComputers(@RequestParam(name = "gpu", required = false) String gpu, Model model) {
        model.addAttribute("currentPage", "index");
        if (gpu != null) {
            model.addAttribute("computers", computerService.filterByGpu(gpu));
        } else {
            model.addAttribute("computers", computerService.getAllComputers());
        }
        return "index";
    }

    /**
     * Показывает детали о компьютере по его идентификатору
     * @param id    Идентификатор компьютера
     * @param model Модель для передачи данных в представление
     * @return Имя представления для отображения
     */
    @GetMapping("computers/{id}")
    public String viewComputerDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("currentPage", "details");
        Computer computer = computerService.getOneComputer(id);
        if (computer != null) {
            model.addAttribute("computers", computer);
            return "show";
        } else {
            logger.error("Computer with id {} not found", id);
            model.addAttribute("error", "Computer not found");
            return "error";
        }
    }

    /**
     * Форма для редактирования компьютера
     * @param id    Идентификатор предмета для редактирования
     * @param model Модель для передачи данных в представление
     * @return Имя представления для отображения
     */
    @GetMapping("computers/{id}/edit")
    public String editComputerForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("currentPage", "edit");
        Computer computer = computerService.getOneComputer(id);
        if (computer != null) {
            model.addAttribute("computers", computer);
            return "edit";
        } else {
            logger.error("Attempted to edit non-existing computer with id {}", id);
            return "error";
        }
    }

    /**
     * Форма для создания компьютера
     * @param model Модель для передачи данных в представление
     * @return Имя представления для отображения
     */
    @GetMapping("/new")
    public String newComputerForm(Model model) {
        model.addAttribute("currentPage", "new");
        model.addAttribute("computers", new Computer());
        return "new";
    }

    /**
     * Создает новую запись о компьютере
     * @param computer         Создаваемый компьютер
     * @param bindingResult      Результат привязки для обработки ошибок
     * @param model              Модель для передачи данных в представление
     * @param redirectAttributes Атрибуты для передачи данных при перенаправлении
     * @return Перенаправление на список всех предметов
     */
    @PostMapping
    public String createComputer(@ModelAttribute("computers") @Valid Computer computer,
                                BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentPage", "new");
            return "new";
        }
        computerService.saveComputer(computer);
        redirectAttributes.addFlashAttribute("message", "Computer successfully added.");
        return "redirect:/";
    }

    /**
     * Обновляет существующую запись компьютера
     * @param computer     ПК для обновления
     * @param bindingResult Результат привязки для обработки ошибок
     * @param id            Идентификатор предмета для обновления
     * @param model         Модель для передачи данных в представление
     * @return Перенаправление на список компьютеров
     */
    @PutMapping("/{id}")
    public String updateComputer(@ModelAttribute("computers") @Valid Computer computer,
                                BindingResult bindingResult, @PathVariable("id") int id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentPage", "edit");
            return "edit";
        }
        if (computerService.doesNotExist(id)) {
            logger.error("Attempted to update non-existing computer with id {}", id);
            return "error";
        }
        computerService.updateComputer(id, computer);
        return "redirect:/";
    }

    /**
     * Удаляет запись о ПК
     * @param id Идентификатор ПК для удаления
     * @return Перенаправление на список компьютеров
     */
    @DeleteMapping("/{id}")
    public String deleteComputer(@PathVariable("id") int id) {
        if (computerService.doesNotExist(id)) {
            logger.error("Attempted to delete non-existing computer with id {}", id);
            return "error";
        }
        computerService.deleteComputer(id);
        return "redirect:/";
    }
}