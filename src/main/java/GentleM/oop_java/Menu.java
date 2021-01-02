package GentleM.oop_java;

import GentleM.oop_java.Interface.IMenu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements IMenu {
    public static final String[][] MENU_ITEMS = {{"americano", "10"}, {"cappuccino", "20"}, {"milkLatte", "20"}, {"cold water", "20"}};
    public static final int MENU_NAME = 0;
    public static final int MENU_PRICE = 1;
    public static final int AMERICANO = 0;
    public static final int CAPUUCCINO = 1;
    public static final int MILK_LATTE = 2;
    public static final int COLD_WATER = 3;

    private ArrayList<MenuItem> _items;

    public Menu(ArrayList<MenuItem> items) {
        addMenu(items);
        this._items = items;
    }

    public void addMenu(ArrayList<MenuItem> items) {
        for (String[] eachMenu : MENU_ITEMS) {
            items.add(new MenuItem(eachMenu[MENU_NAME], Integer.parseInt(eachMenu[MENU_PRICE])));
        }
    }

    @Override
    public MenuItem searchMenuItem(String coffeeName) {
        for (MenuItem eachItem : _items) {
            if (eachItem.getName().equals(coffeeName)) return eachItem;
        }
        return null;
    }

}
