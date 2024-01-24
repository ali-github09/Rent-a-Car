package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private static Db instance = null;
    private Connection connection = null;
    private final String Db_Url= "jdbc:postgresql://localhost:5432/rentacar";
    private final String Db_userName = "postgres";
    private final String Db_password = "1234";

    private Db() {
        try {
            this.connection = DriverManager.getConnection(Db_Url,Db_userName,Db_password);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static Connection getInstance() {

        try {
            if(instance == null || instance.getConnection().isClosed()) {
                instance = new Db();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return instance.getConnection();
    }
}
