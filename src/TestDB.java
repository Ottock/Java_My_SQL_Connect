// src/TestDB.java

// Imports
import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectDB;

public class TestDB{
    public static void main(String[] args) throws Exception{
        System.out.println(">> Connecting with the database");
        Connection conn = null;
        try{
            ConnectDB db = new ConnectDB();
            conn = db.connect();
            System.out.println(">> Database connected successfully!");
        } 
        catch(SQLException e){
            System.out.println(">> ERRO: Failed to connect to the database.");
            e.printStackTrace();
        }

        // Algorithm
        conn.close();
    }
}
