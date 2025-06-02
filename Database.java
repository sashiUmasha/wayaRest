package Practicals;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant_db";
    private static final String USER = "restaurant_db";
    private static final String PASSWORD = "";

    public static boolean insertUser(User user) {
        String query = "INSERT INTO users (username, email, phone, dob, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getDob());
            stmt.setString(5, user.getPassword());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
