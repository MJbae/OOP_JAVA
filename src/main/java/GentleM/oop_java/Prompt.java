package GentleM.oop_java;

import java.util.ArrayList;

public class Prompt {
    private void runPrompt() {
        Customer customer = new Customer();
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        Menu menu = new Menu(items);

        customer.order("americano", menu);
    }



    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.runPrompt();
    }

}
