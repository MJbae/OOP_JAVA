package GentleM.oop_java;

import GentleM.oop_java.Interface.IMenu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private ArrayList<MenuItem> _items = new ArrayList<MenuItem>();
    MenuItem americano = new MenuItem("americano", 10);
    MenuItem greenTea = new MenuItem("greenTea", 15);
    MenuItem cafeMoca = new MenuItem("cafeMoca", 20);
    MenuItem milk = new MenuItem("milk", 5);

    public void addItems(MenuItem item){
        _items.add(item);
    }

}
