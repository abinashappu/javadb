package org.example;

import java.sql.*;
import static org.example.Constants.*;

public class Main {
//    public void addProduct(int product_ID, String name, int price, int quantity) {
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            String insertQuery = "INSERT INTO practice.product (product_ID, name, price, quantity) VALUES (?,?, ?, ?)";
//            try (PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
//                preparedStatement.setInt(1, product_ID);
//                preparedStatement.setString(2, name);
//                preparedStatement.setInt(3, price);
//                preparedStatement.setInt(4, quantity);
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {

//            e.printStackTrace();
//        }
//    }
    public void viewProducts(){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String SelectQuery = "Select * from practice.product";
            try(PreparedStatement preparedStatement = connection.prepareStatement(SelectQuery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
while(resultSet.next()) {
    int productId = resultSet.getInt("product_ID");
    String name = resultSet.getString("name");
    int price = resultSet.getInt("price");
    int quantity = resultSet.getInt("quantity");
    System.out.println("ID: "+productId+",Name: "+name+",Price: "+price+",Quantity: "+quantity);
}
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
//        main.addProduct(5, "laptop",25000,50 );
        main.viewProducts();
        System.out.println("add succesfully");
}
}