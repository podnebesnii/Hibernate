package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    //private final Connection connection = Util.getConnection();

    @Override
    public void createUsersTable() {
        /*try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mydbtest`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `name` VARCHAR(45) NULL," +
                    "  `lastName` VARCHAR(45) NULL," +
                    "  `age` INT NULL," +
                    "  PRIMARY KEY (`id`));");
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */
    }

    @Override
    public void dropUsersTable() {
        /*
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        /*
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name,lastName,age) VALUES (?,?,?)")){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем" + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */

    }

    @Override
    public void removeUserById(long id) {
        /*
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
            preparedStatement.setLong(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        /*
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM users");
            while (result.next()) {
                User user1 = new User();
                user1.setId(result.getLong("id"));
                user1.setName(result.getString("name"));
                user1.setLastName(result.getString("lastName"));
                user1.setAge(result.getByte("age"));
                userList.add(user1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

         */
        return userList;


    }

    @Override
    public void cleanUsersTable() {
        /*
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */
    }
}
