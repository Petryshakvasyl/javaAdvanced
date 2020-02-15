package ua.lviv.lgs.jdbc.crud.repository;

import ua.lviv.lgs.jdbc.crud.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {

    void save(Employee employee);

    void update(Employee employee) throws SQLException;

    void delete(int id) throws SQLException;

    Employee findById(int id) throws SQLException;

    List<Employee> findAll() throws SQLException;
}
