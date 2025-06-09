package test;

import main.Fruit;
import ui.EditFruitFrame;

public class EditTest {
    public static void main(String[] args) {
        Fruit f1 = new Fruit("F001", "Apple", "Fruit", 3.5, "Red apple", "Red", 0.5, "个", "山东", "全熟");
        new EditFruitFrame(f1);
    }
}
