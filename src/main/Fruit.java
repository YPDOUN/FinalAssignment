package main;


public class Fruit extends Product{
    private String color;
    private double weight;
    private String unit;
    private String origin;
    private String ripeness;

    public Fruit() {
        super();
        this.color = null;
        this.weight = 0.0;
        this.unit = null;
        this.origin = null;
        this.ripeness = null;
    }

    public Fruit(String id, String name, String type, double price, String description, String color, double weight, String packageUnit, String origin, String ripeness) {
        super(id, name, type, price, description);
        this.color = color;
        this.weight = weight;
        this.unit = packageUnit;
        this.origin = origin;
        this.ripeness = ripeness;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPackageUnit() {
        return unit;
    }

    public void setPackageUnit(String packageUnit) {
        this.unit = packageUnit;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getRipeness() {
        return ripeness;
    }

    public void setRipeness(String ripeness) {
        this.ripeness = ripeness;
    }

    @Override
    public String toString() {
        return "Fruit [" + super.toString() + "," +
                "颜色=" + color + ", 重量=" + weight + ", " +
                "单位=" + unit + ", 产地=" + origin + ", 成熟度=" + ripeness + "]";
    }
}
