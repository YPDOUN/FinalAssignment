package main;

public class Wood extends Product{
    private String species;
    private double length;
    private double width;
    private double thickness;
    private int moistureContent;

    public Wood() {
    }

    public Wood(String id, String name, String type, double price, String description, String species, double length, double width, double thickness, int moistureContent) {
        super(id, name, type, price, description);
        this.species = species;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.moistureContent = moistureContent;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public int getMoistureContent() {
        return moistureContent;
    }

    public void setMoistureContent(int moistureContent) {
        this.moistureContent = moistureContent;
    }

    @Override
    public String toString() {
        return "Wood [" + super.toString() + "," +
                "树种=" + species + "长度=" + length + "宽度=" + width +
                "厚度=" + thickness + "含水率=" + moistureContent + "]";
    }
}
