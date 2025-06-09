package main;

public abstract class Product {
    private String id;
    private String name;
    private String type;
    private double  price;
    private String description;

    public Product() {
        this.id = null;
        this.name = null;
        this.type = null;
        this.price = 0.0;
        this.description = null;
    }

    public Product(String id, String name, String type, double price, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", 名称=" + name + ", 类型=" + type + ", 价格=" + price + ", 描述=" + description;
    }
}
