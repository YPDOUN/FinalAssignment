package mapper;

import main.Wood;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WoodDAO extends ProductDAO<Wood>{
    public WoodDAO() throws SQLException {
        super();
    }

    @Override
    public void insert(Wood wood) throws SQLException {
        insertProductTable(wood);

        String sql ="INSERT INTO WOOD(product_id, species, length, width, thickness, mositure_content) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, wood.getId());
        ps.setString(2, wood.getSpecies());
        ps.setDouble(3, wood.getLength());
        ps.setDouble(4, wood.getWidth());
        ps.setDouble(5, wood.getThickness());
        ps.setInt(6, wood.getMoistureContent());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public boolean update(Wood product) throws SQLException {
        return false;
    }
}
