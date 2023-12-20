package Demchenko.computer.services;

import Demchenko.computer.models.Computer;
import Demchenko.computer.repository.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Сервис для работы с компьютерами
 */
@Service
@Transactional(readOnly = true)
public class ComputerService {

    private final IComputerRepository repository;

    @Autowired
    public ComputerService(IComputerRepository repository) {
        this.repository = repository;
    }

    /**
     * Возвращает список всех компьютеров из базы данных
     * @return Список компьютеров
     */
    public List<Computer> getAllComputers() {
        return repository.findAll();
    }

    /**
     * Находит компьютер по идентификатору
     *
     * @param id Идентификатор товара
     * @return Найденный компьютер/null
     */
    public Computer getOneComputer(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Обновляет данные о компьютере
     * @param id Идентификатор компьютера
     * @param computer Данные для обновления
     */
    @Transactional
    public void updateComputer(int id, Computer computer) {
        computer.setId(id);
        repository.save(computer);
    }

    /**
     * Сохраняет новую запись
     *
     * @param computer Компьютер для сохранения.
     */
    @Transactional
    public void saveComputer(Computer computer) {
        repository.save(computer);
    }

    /**
     * Удаляет компьютер из базы данных
     * @param id Идентификатор компьютера для удаления
     */
    public void deleteComputer(int id) {
        repository.deleteById(id);
    }

    /**
     * Проверяет наличие компьютера в БД
     * @param id Идентификатор компьютера
     * @return true, если отсутствует, иначе false.
     */
    public boolean doesNotExist(int id) {
        return !repository.existsById(id);
    }

    /**
     * Фильтрует компьютер по цене
     * @param gpu Видеокарта для фильтрации
     * @return Список компьтеров, соответствующей заданному имени.
     */
    public List<Computer> filterByGpu(String gpu) {
        return repository.findByGpuContains(gpu);
    }

    @Transactional
    public void buy(int id) throws IllegalArgumentException {
        Computer computer = repository.findById(id).orElse(null);
        if(computer != null){
            if(computer.getQuantity() > 0) {
                computer.setQuantity(computer.getQuantity() - 1);
            }
            else{
                throw new IllegalArgumentException("No matching computer found");
            }
        }
        else {
            throw new IllegalArgumentException("This computer item does not exist");
        }
    }
}