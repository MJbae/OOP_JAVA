package GentleM.oop_java;

import GentleM.oop_java.Interface.IMenu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private ArrayList<MenuItem> _items = new ArrayList<MenuItem>();

    public void addItems(MenuItem item) {
        _items.add(item);
    }

    public static void main(String[] args){
        Menu menu = new Menu();
        menu.addItems(new MenuItem("americano", 10));
        menu.addItems(new MenuItem("greenTea", 5));
        menu.addItems(new MenuItem("milk", 3));
        menu.addItems(new MenuItem("water", 1));
    }
}
