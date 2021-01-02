package GentleM.oop_java;

import GentleM.oop_java.Interface.ICustomer;

import java.util.ArrayList;

public class Customer implements ICustomer {
    @Override
    public void order(String coffeeName, Menu menu) {
        MenuItem orderedItem = menu.searchMenuItem(coffeeName);
        System.out.println(orderedItem.getName() + " is ordered");
    }

    public static void main(String[] args) {
        Customer customer = new Customer();

        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem("americano", 10));
        items.add(new MenuItem("milktea", 5));
        items.add(new MenuItem("milk", 2));
        items.add(new MenuItem("water", 1));

        Menu menu = new Menu(items);

        customer.order("milk", menu);
    }
}
