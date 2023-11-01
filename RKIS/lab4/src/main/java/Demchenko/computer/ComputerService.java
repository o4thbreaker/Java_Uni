package Demchenko.computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с компьютерами
 */
@Service
public class ComputerService {
    @Autowired
    private ComputerController computerController;

    /**
     * Добавляет новый компьютер
     * @param computer Компьютер для добавления
     */
    public void addComputer(Computer computer) {
        computerController.addComputer(computer);
    }

    /**
     * Возвращает список всех компьютеров из базы данных
     * @return Список компьютеров
     */
    public List<Computer> getAllComputers() {
        return computerController.getAllComputers();
    }

    /**
     * Обновляет данные о компьютере
     * @param id Идентификатор компьютера
     * @param updatedComputer Данные для обновления
     */
    public void updateComputer(Integer id, Computer updatedComputer) {
        computerController.updateComputer(id, updatedComputer);
    }

    /**
     * Удаляет компьютер из базы данных
     * @param id Идентификатор компьютера для удаления
     */
    public void deleteComputer(Integer id) {
        computerController.deleteComputer(id);
    }

    /**
     * Осуществляет поиск компьютеров по заданному полю и значению
     * @param field Поле для поиска
     * @param value Значение для поиска
     * @return Список компьютеров, соответствующих критериям поиска
     */
    public List<Computer> searchComputer(String field, String value) {
        return computerController.searchComputers(field, value);
    }
}