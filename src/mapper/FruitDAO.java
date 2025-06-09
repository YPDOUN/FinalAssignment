package mapper;

import main.Fruit;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FruitDAO extends ProductDAO<Fruit> {
    public FruitDAO() throws SQLException {
        super();
    }

    @Override
    public void insert(Fruit fruit) throws SQLException {
        //插入Product表
        insertProductTable(fruit);

        String sql = "INSERT INTO fruit(product_id, color, weight, unit, origin, ripeness) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, fruit.getId());
        ps.setString(2, fruit.getColor());
        ps.setDouble(3, fruit.getWeight());
        ps.setString(4, fruit.getPackageUnit());
        ps.setString(5, fruit.getOrigin());
        ps.setString(6, fruit.getRipeness());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public boolean update(Fruit fruit) throws SQLException {
        String url = "UPDATE product SET name = ?, type = ?, price = ?, description = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(url);

        ps.setString(1, fruit.getName());
        ps.setString(2, fruit.getType());
        ps.setDouble(3, fruit.getPrice());
        ps.setString(4, fruit.getDescription());
        ps.setString(5, fruit.getId());
        int result = ps.executeUpdate();
        ps.close();

        return result != 0;
    }

}
