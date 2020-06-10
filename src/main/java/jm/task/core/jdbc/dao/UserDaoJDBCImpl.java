package jm.task.core.jdbc.dao;



import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



class UserDaoJDBCImpl implements UserDao {
    Connection connection;
    //language=SQL
    private final String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS users (id  SERIAL PRIMARY KEY ,name VARCHAR(30),age int);";
    //language=SQL
    private final String ADD_MODEL = "INSERT INTO users ( name, age) values (?,?,?)";
    //language=SQL
    private final String SELECT_ALL = "SELECT * FROM users";
    //language=SQL
    private final String DELETE_MODEL = "DELETE FROM users WHERE id=?";
    //language=SQL
    private final String UPDATE_MODEL = "UPDATE users SET name=?, age=? WHERE id=?";


    public UserDaoJDBCImpl(Connection connection) {
        this.connection = connection;
    }





    @Override
    public void createUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE);
            //        statement.executeQuery(CREATE_TABLE);
            int y = 45;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_MODEL);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                users.add(new User(id, name, age));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void cleanUsersTable() {

    }
}