package Demchenko.computer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComputerRepository extends  JpaRepository<Computer, Integer> {

    // Находит все записи по видеокарте.
    List<Computer> findByGpuContains(String gpu);
}
