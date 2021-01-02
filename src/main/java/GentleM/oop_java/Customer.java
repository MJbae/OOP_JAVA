package GentleM.oop_java;

import GentleM.oop_java.Interface.ICustomer;

import java.util.ArrayList;

public class Customer implements ICustomer {
    @Override
    public void order(String coffeeName, Menu menu) {
        MenuItem orderedItem = menu.searchMenuItem(coffeeName);
        Barista barista = new Barista();

        Coffee madeCoffee = barista.makeCoffee(orderedItem);
        madeCoffee.printDescription();
    }

    public static void main(String[] args) {
        Customer customer = new Customer();

        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem("americano", 10));
        items.add(new MenuItem("cappuccino", 25));
        items.add(new MenuItem("milkLatte", 20));
        items.add(new MenuItem("cold water", 15));

        Menu menu = new Menu(items);

        customer.order("cappuccino", menu);
    }
}
