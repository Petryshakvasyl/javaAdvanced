package ua.lviv.lgs.jdbc.crud.repository.imp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.lviv.lgs.jdbc.crud.entity.Employee;
import ua.lviv.lgs.jdbc.crud.mapper.EmployeeMapper;
import ua.lviv.lgs.jdbc.crud.repository.EmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    public static final String CREATE = "INSERT INTO employee2 (first_name, last_name) values(?,?)";
    public static final String UPDATE_BY_ID = "UPDATE employee SET first_name=?, last_name=? WHERE id=?";
    private static String READ_BY_ID = "select * from employee where id =?";
    private final Logger log = Logger.getLogger(EmployeeRepositoryImpl.class);
    private Connection connection;

    public EmployeeRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public void save(Employee employee) {
        log.setLevel(Level.ERROR);
        log.info("save employee ...");
        PreparedStatement statement = null;
        try {
            log.debug("try to prepare statement ");
            statement = connection.prepareStatement(CREATE);
            log.debug("statement is ready ... ");

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            log.debug("exequting query ... ");
            statement.execute();

        } catch (SQLException e) {
            log.error("after trying to exequte query", e);
//            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Employee employee) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID);
        statement.setInt(3, employee.getId());
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.execute();
    }
    private static String DELETE_BY_ID = "delete from employee where id=?";

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Employee findById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Employee result = EmployeeMapper.map(resultSet);
        preparedStatement.close();
        return result;
    }
    private static String READ_ALL = "select * from employee";

    public List<Employee> findAll() throws SQLException {
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            listOfEmployee.add(EmployeeMapper.map(result));
        }
        preparedStatement.close();
        return listOfEmployee;
    }
}
