package Demchenko.computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Класс для работы с базой данных
 */
@Repository
public class ComputerController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Добавляет новую строку в базу данных
     * @param computer Компьютер для добавления
     */
    public void addComputer(Computer computer) {
        String sql = "INSERT INTO computers (gpu, cpu, monitor, ramAmount, price) VALUES (?, ?, ?, ?, ?)";
        System.out.println(sql);
        jdbcTemplate.update(sql, computer.getGpu(), computer.getCpu(), computer.getMonitor(),
                computer.getRamAmount(), computer.getPrice());
    }

    /**
     * Считывает все строки из базы данных
     * @return Все строки из базы данных
     */
    public List<Computer> getAllComputers() {
        String sql = "SELECT * FROM computers";
        return jdbcTemplate.query(sql, new ComputerRowMapper());
    }

    /**
     * Обновляет строку данных в таблице
     * @param id id записи
     * @param updatedComputer Новые данные для записи
     */
    public void updateComputer(Integer id, Computer updatedComputer) {
        String sql = "UPDATE computers SET gpu=?, cpu=?, monitor=?, ramAmount=?, price=? WHERE id=?";
        jdbcTemplate.update(sql, updatedComputer.getGpu(), updatedComputer.getCpu(), updatedComputer.getMonitor(),
                updatedComputer.getRamAmount(), updatedComputer.getPrice(), id);
    }

    /**
     * Удаляет строку в таблицце
     * @param id Идентификатор строки
     */
    public void deleteComputer(Integer id) {
        String sql = "DELETE FROM computers WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * Ищет запись в таблице по значению одного из полей
     * @param field Название поля
     * @param value Значение поля
     * @return Найденная строка
     */
    public List<Computer> searchComputers(String field, String value) {
        String sql = "SELECT * FROM computers WHERE LOWER(" + field + ") LIKE ?";
        return jdbcTemplate.query(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + value.toLowerCase() + "%");
            return ps;
        }, new ComputerRowMapper());
    }

    /**
     * Преобразует результат запроса в объект класса Computer
     */
    private static class ComputerRowMapper implements RowMapper<Computer> {
        @Override
        public Computer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Computer computers = new Computer();
            computers.setId(rs.getInt("id"));
            computers.setGpu(rs.getString("gpu"));
            computers.setCpu(rs.getString("cpu"));
            computers.setMonitor(rs.getString("monitor"));
            computers.setRamAmount(rs.getInt("ramAmount"));
            computers.setPrice(rs.getInt("price"));
            return computers;
        }
    }
}