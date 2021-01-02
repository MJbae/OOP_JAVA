package GentleM.oop_java;

import GentleM.oop_java.Interface.IBarista;

public class Barista implements IBarista {
    @Override
    public Coffee makeCoffee(MenuItem item) {
        return new Coffee(item.getName(), item.getPrice());
    }
}
