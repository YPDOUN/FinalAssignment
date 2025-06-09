package test;

import main.*;
import mapper.FruitDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


class InventoryMainTest {
    public static void main(String[] args) throws SQLException {
        FruitDAO fruitDAO = new FruitDAO();
        Inventory inventory = fruitDAO.loadProductTable();
        Map<Product, Integer> stock = inventory.getStock();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--------------系统--------------");
            System.out.println("-----------1.添加商品-----------");
            System.out.println("-----------2.修改商品-----------");
            System.out.println("请输入选项：");
            String choice = sc.nextLine();
            switch (choice){
                case "1" -> addProduct(inventory, sc);
                case "0" -> System.exit(0);
            }
        }
    }
    //以下为修改商品的业务逻辑
    public static void searchProduct(Inventory inventory, Scanner sc) {
        System.out.println("请输入ID：");
        String id = sc.nextLine();
        Product product = inventory.findProductById(id);

        if(product == null) {
            System.out.println("该商品不存在！");
            return;
        }
        //以下为商品存在的业务逻辑

    }
    //以下为添加商品的业务逻辑
    public static void addProduct(Inventory inventory, Scanner sc) {
        System.out.println("请输入需要录入的商品品类（1.水果 2.木材 3.药材 0.退出：");
        while (true) {
            String choice = sc.nextLine();
            switch (choice){
                case "1" -> addProducts(inventory, sc, "Fruit");
                case "2" -> addProducts(inventory, sc, "Wood");
                case "3" -> addProducts(inventory, sc, "Herb");
                case "0" -> { return; }
            }
        }
    }

    private static void addProducts(Inventory inventory, Scanner sc, String type) {
        String id = isIdValid(inventory, sc);
        String name = InputHelper.inputString("请输入商品名称：", sc);
        double price = InputHelper.inputDouble("请输入商品价格：", sc);
        String description = InputHelper.inputString("请输入商品描述：", sc);
        switch (type){
            case "Fruit" -> {
                String color = InputHelper.inputString("请输入水果颜色：", sc);
                double weight = InputHelper.inputDouble("请输入水果重量：", sc);
                String unit = InputHelper.inputString("请输入水果单位：", sc);
                String origin = InputHelper.inputString("请输入水果产地：", sc);
                String ripeness = InputHelper.inputString("请输入水果成熟度：", sc);
                int quantity = InputHelper.inputInt("请输入该批水果数量：", sc);

                Fruit fruit = new Fruit(id, name, type.toString(), price, description, color, weight, unit, origin, ripeness);
                inventory.add(fruit, quantity);
                System.out.println("录入成功！");
            }
            case "Herb" -> {
                String herbName = InputHelper.inputString("请输入药材名称：", sc);
                String herbOrigin = InputHelper.inputString("请输入药材产地：", sc);
                String season = InputHelper.inputString("请输入采摘季节：", sc);
                int shelfLife = InputHelper.inputInt("请输入药材保质期：", sc);
                int quantity = InputHelper.inputInt("请输入该批药材数量：", sc);
                Herb herb = new Herb(id, name, type.toString(), price, description, herbName, herbOrigin, season, shelfLife);
                inventory.add(herb, quantity);
                System.out.println("录入成功！");
            }
            case "Wood" -> {
                String species = InputHelper.inputString("请输入木材树种：", sc);
                double length = InputHelper.inputDouble("请输入木材长度：", sc);
                double width = InputHelper.inputDouble("请输入木材宽度：", sc);
                double thickness = InputHelper.inputDouble("请输入木材厚度：", sc);
                int moistureContent = InputHelper.inputInt("请输入木材含水率：", sc);
                int quantity = InputHelper.inputInt("请输入该批木材数量：", sc);
                Wood wood = new Wood(id, name, type.toString(), price, description, species, length, width, thickness, moistureContent);
                inventory.add(wood, quantity);
                System.out.println("录入成功！");
            }
        }
    }

    private static String isIdValid(Inventory inventory, Scanner sc) {
        String id;
        while(true){
            System.out.println("请输入商品ID：");
            id = sc.nextLine();
            //判断ID唯一性
            if (inventory.findProductById(id) != null) {
                System.out.println("该商品ID已经存在！请重新输入！");
                continue;
            }
            if (id.isEmpty()) {
                System.out.println("输入不能为空白！请重新输入！");
                continue;
            }
            break;
        }
        return id;
    }

    public static int test(Inventory inventory, Class<?> clazz){
        ArrayList<Product> products = inventory.getAllProducts();

        int count = 0;
        for(Product p : products){
            if(clazz.isInstance(p))
                count++;
        }
        return count;
    }
}