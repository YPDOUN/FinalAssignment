package test;


import main.Inventory;
import mapper.FruitDAO;
import ui.InventoryUI;

import java.sql.SQLException;

class InventoryUITest {
    public static void main(String[] args) throws SQLException {
        FruitDAO fruitDAO = new FruitDAO();
        Inventory inventory = fruitDAO.loadProductTable();
        new InventoryUI(inventory).setVisible(true);
    }
}