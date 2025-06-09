package mapper;

import main.Product;

import java.sql.*;
import java.util.Map;

public class InventoryDAO{
    private Connection conn;

    private InventoryDAO() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1/productSystem";
        String user = "root";
        String pass = "123456";
        conn = DriverManager.getConnection(url, user, pass);
    }

    public void insertInventory(Map.Entry<Product, Integer> entity) throws SQLException {
        String sql = "INSERT INTO inventory(product_id, quantity) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        String id = entity.getKey().getId();
        int quantity = entity.getValue();

        ps.setInt(1, Integer.parseInt(id));
        ps.setInt(2, quantity);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
