package GentleM.oop_java;

import GentleM.oop_java.Interface.IMenuItem;

public class MenuItem implements IMenuItem {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice(){
        return price;
    }
}
