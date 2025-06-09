package mapper;

import main.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class ProductDAO<T extends Product> {
    protected Connection conn;

    protected ProductDAO() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1/productSystem";
        String name = "root";
        String pass = "123456";
        conn = DriverManager.getConnection(url, name, pass);
    }

    protected void insertProductTable(Product product) throws SQLException {
        String sql = "insert into product(id, name, type, price, description) values(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, product.getId());
        ps.setString(2, product.getName());
        ps.setString(3, product.getType());
        ps.setDouble(4, product.getPrice());
        ps.setString(5, product.getDescription());
        ps.executeUpdate();

        ps.close();
    }

    public Inventory loadProductTable() throws SQLException {
        String sql = "SELECT * FROM product p " +
                "LEFT JOIN fruit f on f.product_id = p.id " +
                "LEFT JOIN wood w ON w.product_id = p.id " +
                "LEFT JOIN herb h ON h.product_id = p.id " +
                "LEFT JOIN inventory i ON i.product_id = p.id";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Product> products = new ArrayList<>();
        Map<Product, Integer> stock = new HashMap<>();
        while (rs.next()) {
            //
            String id = rs.getString("id");
            String name = rs.getString("name");
            String type = rs.getString("type");
            double price = rs.getDouble("price");
            String description = rs.getString("description");

            switch (type){
                case "Fruit" -> {
                    String color = rs.getString("color");
                    double weight = rs.getDouble("weight");
                    String unit = rs.getString("unit");
                    String origin = rs.getString("origin");
                    String ripeness = rs.getString("ripeness");
                    int quantity = rs.getInt("quantity");
                    Fruit fruit = new Fruit(id, name, type, price, description, color, weight, unit, origin, ripeness);
                    products.add(fruit);
                    stock.put(fruit, quantity);
                }
                case "Wood" -> {
                    String species = rs.getString("species");
                    double length = rs.getDouble("length");
                    double width = rs.getDouble("width");
                    double thickness = rs.getDouble("thickness");
                    int moistureContent = rs.getInt("moisture_Content");
                    int quantity = rs.getInt("quantity");
                    Wood wood = new Wood(id, name, type, price, description, species, length, width, thickness, moistureContent);
                    products.add(wood);
                    stock.put(wood, quantity);
                }
                case "Herb" ->{
                    String herbName = rs.getString("herb_name");
                    String herbOrigin = rs.getString("herb_origin");
                    String season = rs.getString("season");
                    int shelfLife = rs.getInt("shelf_life");
                    int quantity = rs.getInt("quantity");
                    Herb herb = new Herb(id, name, type, price, description, herbName, herbOrigin, season, shelfLife);
                    products.add(herb);
                    stock.put(herb, quantity);
                }
            }
        }
        rs.close();
        return new Inventory(products, stock);
    }

    public abstract void insert(T product) throws SQLException;

    public abstract boolean update(T product) throws SQLException;
}
