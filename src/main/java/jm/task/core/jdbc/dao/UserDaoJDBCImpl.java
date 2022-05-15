package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        String tableUsers = "CREATE TABLE `mydbtest`.`users` (" +
                "  `id` INT NOT NULL AUTO_INCREMENT," +
                "  `name` VARCHAR(45) NULL," +
                "  `lastName` VARCHAR(45) NULL," +
                "  `age` INT NULL," +
                "  PRIMARY KEY (`id`));";

        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(tableUsers);
        } catch (SQLException e) {
        }

    }

    @Override
    public void dropUsersTable() {
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE users");
        } catch (SQLException e) {

        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO users(name,lastName,age) VALUES ('" + name + "','" + lastName + "'," + age + ")");
            System.out.println("User с именем" + name + " добавлен в базу данных");
        } catch (SQLException e) {
        }

    }

    @Override
    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM users WHERE id =" + id);
        } catch (SQLException e) {
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM users");
            while (result.next()){
                User user1 = new User();
                user1.setId(result.getLong("id"));
                user1.setName(result.getString("name"));
                user1.setLastName(result.getString("lastName"));
                user1.setAge(result.getByte("age"));
                userList.add(user1);
            }

        } catch (SQLException e) {
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
        }

    }
}
