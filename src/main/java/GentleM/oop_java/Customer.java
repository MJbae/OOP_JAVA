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
}
