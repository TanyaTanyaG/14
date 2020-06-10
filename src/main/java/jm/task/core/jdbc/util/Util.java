package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    private Object Statement;
    private SQLException e;

    public Util() {
    }

    public Driver Util() {
        Driver result = null;

        Driver driver = new FabricMySQLDriver ( );
        try {
            DriverManager.registerDriver (driver);
        } catch (SQLException ex) {
            System.out.println ("Не удалось зарегистрировать драйвер!");
            result = driver;
        }
        if (result == null) {
            try {
                String URL = "jdbc:mysql://localhost:3306/usersdb?useSSL=false&serverTimezone=UTC";
                String loginName = "root";
                String password = "rootroot";
                Connection connection = DriverManager.getConnection (URL, loginName, password);
                System.out.println ("code");
            } catch (SQLException ex) {
                System.out.println ("Не удалось создать соединение!");

            }


            result = driver;
        }
        return result;
    }

    public Object getConnecton() {
        return Statement;
    }

    public SQLException getE() {
        return e;
    }

    public void setE(SQLException e) {
        this.e = e;
    }

    public void setStatement(Object statement) {
        Statement = statement;
    }


    // реализуйте настройку соеденения с БД
}
