package Demchenko.computer.controllers;

import Demchenko.computer.models.Computer;
import Demchenko.computer.services.ComputerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер REST API
 */
@RestController
@RequestMapping("/api")
public class RestComputerController {
    private static final Logger logger = LoggerFactory.getLogger(ComputerController.class);

    private final ComputerService computerService;

    /**
     * Конструктор класса RestComputerController
     * @param computerService сервис для работы с предметами одежды
     */
    @Autowired
    public RestComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    /**
     * Возвращает все записи о предметах одежды
     * @return список предметов одежды
     */
    @GetMapping("/computer")
    public List<Computer> getAll() {
        return computerService.getAllComputers();
    }

    /**
     * Возвращает компьютер с заданным id
     * @param id индекс
     * @return ответ на запрос
     */
    @GetMapping("/computer/{id}")
    public ResponseEntity<Computer> getById(@PathVariable("id") int id) {
        Computer computer = computerService.getOneComputer(id);
        if (computer != null) {
            return new ResponseEntity<>(computer, HttpStatus.OK);
        } else {
            logger.error("Computer with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Добавляет компьютер в базу данных
     * @param computer новый предмет одежды
     * @return ответ на запрос
     */
    @PostMapping
    public ResponseEntity<Computer> create(@RequestBody @Valid Computer computer) {
        computerService.saveComputer(computer);
        return new ResponseEntity<>(computer, HttpStatus.CREATED);
    }

    /**
     * Обновляет компьютер по индексу
     * @param computer обновлённый предмет одежды
     * @param id индекс изменяемого компьютера
     * @return ответ на запрос
     */
    @PutMapping("/{id}")
    public ResponseEntity<Computer> update(@RequestBody @Valid Computer computer, @PathVariable("id") int id) {
        if (computerService.doesNotExist(id)) {
            logger.error("Attempted to update non-existing computer with id {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computerService.updateComputer(id, computer);
        return new ResponseEntity<>(computer, HttpStatus.OK);
    }

    /**
     * Удаляет компьютер по индексу
     * @param id индекс удаляемого объекта
     * @return ответ на запрос
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComputer(@PathVariable("id") int id) {
        if (computerService.doesNotExist(id)) {
            logger.error("Attempted to delete non-existing computer with id {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computerService.deleteComputer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
