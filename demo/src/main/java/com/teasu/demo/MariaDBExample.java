package com.teasu.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBExample {
	public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/vmm?useSSL=false";
        String username = "root";
        String password = "rootroot";

        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Connection 成功建立，可以進行數據庫操作
            System.out.println("Connection successful!");
            // 在這裡添加你的數據庫操作代碼

            connection.close(); // 關閉連接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
