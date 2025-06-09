package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory{
    private  ArrayList<Product> products = new ArrayList<>();
    private  Map<Product, Integer> stock = new HashMap<>();

    public Inventory(){
    }

    public Inventory(ArrayList<Product> products, Map<Product, Integer> stock) {
        this.products = products;
        this.stock = stock;
    }

    //添加进商品列表和库存表
    public void add(Product product, int quantity) {
        products.add(product);
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
    }

    //销售商品
    public boolean remove(Product product, int quantity) {
        //首先判断该产品是否在库存中
        if(!stock.containsKey(product)){
            return false;
        }
        //再判断库存数量是否足够
        if(stock.get(product) < quantity){
            return false;
        }
        //满足前置条件便插入
        stock.put(product,stock.get(product) - quantity);
        return true;
    }

    public void query() {
        for(Product product : products){
            System.out.println(product);
        }
    }

    //判断ID是否唯一
    public boolean containsId(String id) {
        for(Product product : products){
            if(product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    //获取products商品列表
    public ArrayList<Product> getAllProducts() {
        return products;
    }

    //获取stock库存数量
    public Map<Product, Integer> getStock() {
        return stock;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setStock(Map<Product, Integer> stock) {
        this.stock = stock;
    }
}
