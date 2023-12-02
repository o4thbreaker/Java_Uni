package Demchenko.computer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Demchenko.computer.models.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Репозиторий для работы с предметами одежды
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    /**
     * Получает пользователя по имени
     * @param username имя пользователя
     * @return объект пользователя системы
     */
    Optional<User> findByUsername(String username);

}
