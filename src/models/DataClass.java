// src/models/DataClass.java
package models;

// Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataClass {
    // Attributes
    private int id;
    private String name;
    private float value;

    // Constructor
    public DataClass(int id, String name, float value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(float value) {
        this.value = value;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getValue() {
        return value;
    }

    // Methods
    //@Override
    //public String toString(){}

    // DATABASE C.R.U.D Methods
    /// Create data Functions
    public void create(Connection conn) throws SQLException {// INSERT INTO table(values, ...) VALUES(?, ...)
        String sql = "INSERT INTO T (id, name, value) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Values to be added on the TABLE
            //pstmt.setString(x, this.get'Type');
            //pstmt.setInt(x, this.get'Type');
            //pstmt.setDouble(x, this.get'Type');
            //pstmt.setChar(x, this.get'Type');

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setFloat(3, value);

            pstmt.executeUpdate();
        }
    }

    /// Read data Function
    public void read(Connection conn) throws SQLException {// SELECT value, ... FROM table WHERE VALUE = ?
        String sql = "SELECT * FROM T WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // WHERE value
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // GET VALUES
                    //this.atribute = rs.get'Type'("Attribute");

                    this.name = rs.getString("name");
                    this.value = rs.getFloat("value");
                }
            }
        }
    }

    /// Update data Function
    public void update(Connection conn) throws SQLException {// UPDATE table SET value = ?, ... WHERE VALUE = ?
        String sql = "UPDATE T SET name = ?, value = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Values to be added on the TABLE
            pstmt.setString(1, name);
            pstmt.setFloat(2, value);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        }
    }

    /// Delete data Function
    public void delete(Connection conn) throws SQLException {// DELETE FROM table WHERE value = ?
        String sql = "DELETE FROM T WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // TABLE with value to be deleted
            //pstmt.setInt();

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

}
