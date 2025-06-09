package test;

import main.Fruit;
import mapper.FruitDAO;

import java.sql.SQLException;

public class FruitDAOTest {
    public static void main(String[] args) throws SQLException {
        FruitDAO fruitDAO = new FruitDAO();
        //Fruit f1 = new Fruit("F001", "Apple", "Fruit", 3.5, "Red apple", "Red", 0.5, "个", "山东", "全熟");
        Fruit f2 = new Fruit("F002", "Banana", "Fruit", 2.2, "Sweet banana", "Yellow", 0.3, "斤", "云南", "半熟");

        //System.out.println(fruitDAO.loadProductTable().size());
    }
}
