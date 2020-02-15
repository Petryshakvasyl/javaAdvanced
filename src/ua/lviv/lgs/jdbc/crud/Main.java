package ua.lviv.lgs.jdbc.crud;

import ua.lviv.lgs.jdbc.crud.conneciton.ConnectionManager;
import ua.lviv.lgs.jdbc.crud.entity.Employee;
import ua.lviv.lgs.jdbc.crud.repository.EmployeeRepository;
import ua.lviv.lgs.jdbc.crud.repository.imp.EmployeeRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionManager.createConnection();
        EmployeeRepository repository = new EmployeeRepositoryImpl(connection);

        Employee employee = new Employee("Jon", "Snow");
        repository.save(employee);
        Employee employeeToUpdate = new Employee(52, "Jonny", "Deept");
        repository.update(employeeToUpdate);

        System.out.println(repository.findById(52));

        System.out.println(repository.findAll());

    }
}
