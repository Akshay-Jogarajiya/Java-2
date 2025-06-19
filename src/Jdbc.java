import java.sql.*;
import java.util.Scanner;

public class Jdbc {

    static final String URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASS = "root";

    static Connection conn;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n=== USER MANAGER ===");
                System.out.println("1. Add User");
                System.out.println("2. View All Users");
                System.out.println("3. Update User");
                System.out.println("4. Delete User");
                System.out.println("5. Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addUser();
                    case 2 -> viewUsers();
                    case 3 -> updateUser();
                    case 4 -> deleteUser();
                    case 5 -> {
                        System.out.println("Goodbye!");
                        conn.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addUser() throws SQLException {
        sc.nextLine(); // clear buffer
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.executeUpdate();
        System.out.println("User added.");
    }

    static void viewUsers() throws SQLException {
        String sql = "SELECT * FROM users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n--- Users ---");
        while (rs.next()) {
            System.out.printf("ID: %d | Name: %s | Email: %s\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"));
        }
    }

    static void updateUser() throws SQLException {
        System.out.print("Enter user ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("New name: ");
        String name = sc.nextLine();
        System.out.print("New email: ");
        String email = sc.nextLine();

        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setInt(3, id);
        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("User updated.");
        } else {
            System.out.println("User not found.");
        }
    }

    static void deleteUser() throws SQLException {
        System.out.print("Enter user ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("User deleted.");
        } else {
            System.out.println("User not found.");
        }
    }
}
