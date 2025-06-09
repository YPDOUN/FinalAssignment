package main;

public class Herb extends Product{
    private String herbName;
    private String herbOrigin;
    private String season;
    private int shelfLife;

    public Herb() {
    }

    public Herb(String id, String name, String type, double price, String description, String herbName, String herbOrigin, String season, int shelfLife) {
        super(id, name, type, price, description);
        this.herbName = herbName;
        this.herbOrigin = herbOrigin;
        this.season = season;
        this.shelfLife = shelfLife;
    }

    public String getHerbName() {
        return herbName;
    }

    public void setHerbName(String herbName) {
        this.herbName = herbName;
    }

    public String getHerbOrigin() {
        return herbOrigin;
    }

    public void setHerbOrigin(String herbOrigin) {
        this.herbOrigin = herbOrigin;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public String toString() {
        return "Herb [" + super.toString() + "," +
                "药材名称=" + herbName + ", 药材产地=" + herbOrigin + "采摘季节=" + season
                +"保质期" + shelfLife;
    }
}
