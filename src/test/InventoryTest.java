package test;

import main.*;
import mapper.FruitDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

class InventoryTest {

    public static void main(String[] args) throws SQLException {
        FruitDAO fruitDAO = new FruitDAO();
        Inventory inventory = fruitDAO.loadProductTable();

        Map<Product, Integer> stock = inventory.getStock();
        for(Map.Entry<Product, Integer> entry : stock.entrySet()){
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(product + " " + quantity);
        }
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入需要录入的商品品类（1.水果 2.木材 3.药材 0.退出：");
            System.out.println(inventory.getAllProducts().size());
            String choice = sc.nextLine();
            switch (choice){
                case "1" -> addFruit(inventory, sc);
                case "2" -> addWood(inventory, sc);
                case "3" -> addHerb(inventory, sc);
                case "0" -> System.exit(0);
            }
        }
    }

    public static void addHerb(Inventory inventory, Scanner sc) {
        while(true){
            String type = "Herb";
            System.out.println("请输入商品ID：");
            String id = sc.nextLine();

            //判断ID唯一性
            if(inventory.containsId(id)){
                System.out.println("该商品ID已经存在！请重新输入！");
                continue;
            }
            if(type.isEmpty()){
                System.out.println("输入不能为空白！请重新输入！");
            }
            String name = InputHelper.inputString("请输入药材名称：", sc);
            double price = InputHelper.inputDouble("请输入药材价格：", sc);
            String description = InputHelper.inputString("请输入药材描述：", sc);
            String herbName = InputHelper.inputString("请输入药材名称：", sc);
            String herbOrigin = InputHelper.inputString("请输入药材产地：", sc);
            String season = InputHelper.inputString("请输入采摘季节：", sc);
            int shelfLife = InputHelper.inputInt("请输入药材保质期：", sc);
            int quantity = InputHelper.inputInt("请输入该批药材数量：", sc);

            Herb herb = new Herb(id, name, type, price, description, herbName, herbOrigin, season, shelfLife);
            inventory.add(herb, quantity);
            System.out.println("录入成功！");
            break;
        }
    }

    public static void addWood(Inventory inventory, Scanner sc) {
        while(true){
            String type = "Wood";
            System.out.println("请输入商品ID：");
            String id = sc.nextLine();

            //判断ID唯一性
            if(inventory.containsId(id)){
                System.out.println("该商品ID已经存在！请重新输入！");
                continue;
            }
            if(type.isEmpty()){
                System.out.println("输入不能为空白！请重新输入！");
            }
            String name = InputHelper.inputString("请输入木材名称：", sc);
            double price = InputHelper.inputDouble("请输入木材价格：", sc);
            String description = InputHelper.inputString("请输入木材描述：", sc);
            String species = InputHelper.inputString("请输入木材树种：", sc);
            double length = InputHelper.inputDouble("请输入木材长度：", sc);
            double width = InputHelper.inputDouble("请输入木材宽度：", sc);
            double thickness = InputHelper.inputDouble("请输入木材厚度：", sc);
            int moistureContent = InputHelper.inputInt("请输入木材含水率：", sc);
            int quantity = InputHelper.inputInt("请输入该批木材数量：", sc);

            Wood wood = new Wood(id, name, type, price, description, species, length, width, thickness, moistureContent);
            inventory.add(wood, quantity);
            System.out.println("录入成功！");
            break;
        }
    }

    public static void addFruit(Inventory inventory, Scanner sc) {
        while(true){
            String type = "Fruit";
            System.out.println("请输入商品ID：");
            String id = sc.nextLine();

            //判断ID唯一性
            if(inventory.containsId(id)){
                System.out.println("该商品ID已经存在！请重新输入！");
                continue;
            }
            if(type.isEmpty()){
                System.out.println("输入不能为空白！请重新输入！");
            }
            String name = InputHelper.inputString("请输入水果名称：", sc);
            double price = InputHelper.inputDouble("请输入水果价格：", sc);
            String description = InputHelper.inputString("请输入水果描述：", sc);
            String color = InputHelper.inputString("请输入水果颜色：", sc);
            double weight = InputHelper.inputDouble("请输入水果重量：", sc);
            String unit = InputHelper.inputString("请输入水果单位：", sc);
            String origin = InputHelper.inputString("请输入水果产地：", sc);
            String ripeness = InputHelper.inputString("请输入水果成熟度：", sc);
            int quantity = InputHelper.inputInt("请输入该批水果数量：", sc);

            Fruit fruit = new Fruit(id, name, type, price, description, color, weight, unit, origin, ripeness);
            inventory.add(fruit, quantity);
            System.out.println("录入成功！");
            break;
        }
    }

    public static int test(Inventory inventory, Class clazz){
        ArrayList<Product> products = inventory.getAllProducts();

        int count = 0;
        for(Product p : products){
            if(clazz.isInstance(p))
                count++;
        }
        return count;
    }
}