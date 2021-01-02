package GentleM.oop_java;

import GentleM.oop_java.Interface.IMenu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements IMenu{
    private ArrayList<MenuItem> _items;

    public Menu(ArrayList<MenuItem> items){
        this._items = items;
    }

    @Override
    public MenuItem searchMenuItem(String coffeeName) {
        for(MenuItem eachItem : _items){
            if(eachItem.getName().equals(coffeeName)) return eachItem;
        }
        return null;
    }

}
