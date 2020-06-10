package jm.task.core.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/usersdb?useSSL=false&serverTimezone=UTC";



    public static void main(String[] args) throws Exception {



        executeUpdate();
        createCustomerTable();
        dropUsersTable ();
        saveUser();
        removeUserById();
        getAllUsers();
        cleanUsersTable();
    }

    public static void executeUpdate() {
    }


    public static void executeUpdate(String query) throws Exception {
        Connection connection;
        try {
            String LoginName = "root";
            String Password = "rootroot";
            connection = DriverManager.getConnection(URL, LoginName, Password);
            Statement statement = getStatement (connection);
            /* Для Insert, Update, Delete */
            statement.executeUpdate (query);
        }
        catch (SQLException ex){
            System.out.println("Не удалось создать соединение!");

        }

    }

    @SuppressWarnings("EmptyTryBlock")
    private static Statement getStatement(Connection connection) throws Exception {
        try {

        } catch (Exception ex) {
            ex.printStackTrace ( );
        }
        return connection.createStatement ( );

    }


    private static void createCustomerTable() throws Exception {
        String customerTableQuery = "CREATE TABLE customers " +
                "(id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
        String customerEntryQuery = "INSERT INTO customers " +
                "VALUES (73, 'Brian', 33)";
        executeUpdate (customerTableQuery);
        executeUpdate (customerEntryQuery);
    }

    private static void dropUsersTable() throws Exception {
        String customerTableQuery = "DROP TABLE customers " +
                "(id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
        String customerEntryQuery = "DELETE INTO customers VALUES (73, 'Brian', 33)";
        executeUpdate (customerTableQuery);
        executeUpdate (customerEntryQuery);
    }
    private static void saveUser() {

    }
    private static void removeUserById() {

    }
    private static void  getAllUsers() {

    }
    private static void cleanUsersTable() {

    }
}