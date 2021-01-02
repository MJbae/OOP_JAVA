package GentleM.oop_java;

import GentleM.oop_java.Interface.IMenu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements IMenu {
    private ArrayList<MenuItem> _items;

    public Menu(ArrayList<MenuItem> items) {
        addMenu(items);
        this._items = items;
    }

    public void addMenu(ArrayList<MenuItem> items) {
        items.add(new MenuItem("americano", 10));
        items.add(new MenuItem("cappuccino", 25));
        items.add(new MenuItem("milkLatte", 20));
        items.add(new MenuItem("cold water", 15));
    }

    @Override
    public MenuItem searchMenuItem(String coffeeName) {
        for (MenuItem eachItem : _items) {
            if (eachItem.getName().equals(coffeeName)) return eachItem;
        }
        return null;
    }

}
