package GentleM.oop_java;

import GentleM.oop_java.Interface.IMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu implements IMenu {
    public static final String[] MENU_ITEMS = {"americano", "cappuccino", "milkLatte", "cold water"};
    public static final HashMap<String, Integer> MENU_PRICES = new HashMap<>();

    public static final int AMERICANO = 0;
    public static final int CAPUUCCINO = 1;
    public static final int MILK_LATTE = 2;
    public static final int COLD_WATER = 3;

    private ArrayList<MenuItem> _items;

    public Menu(ArrayList<MenuItem> items) {
        setPrice();
        addMenu(items);
        this._items = items;
    }

    public void addMenu(ArrayList<MenuItem> items) {
        for (String eachMenu : MENU_ITEMS) {
            items.add(new MenuItem(eachMenu, MENU_PRICES.get(eachMenu)));
        }
    }

    public void setPrice(){
        MENU_PRICES.put(MENU_ITEMS[AMERICANO], 10);
        MENU_PRICES.put(MENU_ITEMS[CAPUUCCINO], 20);
        MENU_PRICES.put(MENU_ITEMS[MILK_LATTE], 15);
        MENU_PRICES.put(MENU_ITEMS[COLD_WATER], 30);
    }

    @Override
    public MenuItem searchMenuItem(String itemName) {
        for (MenuItem eachItem : _items) {
            if (eachItem.getName().equals(itemName)) return eachItem;
        }
        return null;
    }

}
