// src/Test.java

// Imports
import connection.ConnectDB;
import models.DataClass;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        // Creating an Instance for ConnectDB
        ConnectDB connectDB = new ConnectDB();
        Connection conn = null;

        try {
            System.out.println(">> Connecting to the database...");
            conn = connectDB.connect();

            // Creating an new Instance Data
            DataClass data = new DataClass(1, "Example", 123.45f);

            // Creating a new data to the DB
            data.create(conn);
            System.out.println(">> Data created.");

            // Reading the data on an DB
            data.read(conn);
            System.out.println(">> Data read: " + data.getName() + ", " + data.getValue());

            // Updating the data on the DB
            data.setName("Updated Example");
            data.setValue(543.21f);
            data.update(conn);
            System.out.println(">> Data updated.");

            // Reading the data
            data.read(conn);
            System.out.println(">> Updated data read: " + data.getName() + ", " + data.getValue());

            // Deleting the data
            data.delete(conn);
            System.out.println(">> Data deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println(">> Closing the connection to the database.");
            connectDB.close(conn);
        }
    }
}
