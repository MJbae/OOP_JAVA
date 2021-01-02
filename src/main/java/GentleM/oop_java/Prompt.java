package GentleM.oop_java;

import java.util.ArrayList;

import static GentleM.oop_java.Menu.MENU_ITEMS;
import static GentleM.oop_java.Menu.AMERICANO;
import static GentleM.oop_java.Menu.CAPUUCCINO;
import static GentleM.oop_java.Menu.MILK_LATTE;
import static GentleM.oop_java.Menu.COLD_WATER;

public class Prompt {
    private void runPrompt() {
        Customer customer = new Customer();
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        Menu menu = new Menu(items);

        customer.order(MENU_ITEMS[MILK_LATTE], menu);
    }



    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.runPrompt();
    }

}
