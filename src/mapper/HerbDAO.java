package mapper;

import main.Herb;
import main.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HerbDAO extends ProductDAO<Herb> {
    public HerbDAO() throws SQLException {
        super();
    }

    @Override
    public void insert(Herb herb) throws SQLException {
        //插入product表
        insertProductTable(herb);

        String sql = "INSERT INTO herb(product_id, herb_name, herb_origin, season, shelf_life) VALUES(?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, herb.getId());
        ps.setString(2, herb.getName());
        ps.setString(3, herb.getHerbOrigin());
        ps.setString(4, herb.getSeason());
        ps.setInt(5, herb.getShelfLife());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public boolean update(Herb herb) throws SQLException {
//        String sql = "UPDATE herb SET herb_name = ?, herb_origin = ?, season = ?, shelf_life = ? WHERE product_id";
//        PreparedStatement ps = conn.prepareStatement(sql);

        return false;
    }
}
