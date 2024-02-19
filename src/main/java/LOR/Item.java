package LOR;

public class Item {
    private final String name;
    private final int value;
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
    Item(String name, int value){
        this.name = name;
        this.value = value;
    }
}

