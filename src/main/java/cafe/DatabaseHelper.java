/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe;

/**
 *
 * @author jonathan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:cafe.db";
    
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public static void initializeDB() {
        String sql = "CREATE TABLE IF NOT EXISTS menu_items (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " price REAL NOT NULL,\n"
                + " image_path TEXT\n"
                + ");";
        
        String insertItems = "INSERT OR IGNORE INTO menu_items (name, price, image_path) VALUES\n"
                + "('Caffè Americano', 3.0, 'path_to_image1'),\n"
                + "('Cold Brew', 5.0, 'path_to_image2'),\n"
                + "('Vanilla Sweet Cream Cold', 2.5, 'path_to_image3'),\n"
                + "('Cold Coffee', 3.0, 'path_to_image4'),\n"
                + "('Item 5', 3.0, 'path_to_image5'),\n"
                + "('Item 6', 2.0, 'path_to_image6'),\n"
                + "('Item 7', 6.0, 'path_to_image7'),\n"
                + "('Item 8', 3.5, 'path_to_image8');";
        
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.execute(insertItems);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createOrderTable() {
        String sql = "CREATE TABLE IF NOT EXISTS orders (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " order_date TEXT NOT NULL,\n"
                + " subtotal REAL NOT NULL,\n"
                + " tax REAL NOT NULL,\n"
                + " total REAL NOT NULL,\n"
                + " items TEXT NOT NULL\n"
                + ");";
        
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}