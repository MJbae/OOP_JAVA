package GentleM.oop_java;

import java.util.ArrayList;

import static GentleM.oop_java.Menu.*;

public class Prompt {
    private void runPrompt() {
        Customer customer = new Customer();
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        Menu menu = new Menu(items);

        customer.order(MENU_ITEMS[AMERICANO], menu);
    }

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.runPrompt();
    }

}
