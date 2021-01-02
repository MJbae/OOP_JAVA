package GentleM.oop_java;

public class Coffee {
    private String _name;
    private int _price;
    private String _flavor;

    public Coffee(String name, int price){
        _name = name;
        _price = price;

        addFlavor(_name);
    }

    public void addFlavor(String name) {
        if (name.equals("americano")) _flavor = "Fragrant";
        else if (name.equals("cappuccino")) _flavor = "Savory";
        else _flavor = "soso";
    }

    public void printDescription(){
        System.out.println("your Coffee is " + _name + ", price is " + _price + "$ and flavor is " + _flavor);
    }
}
