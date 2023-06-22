package Lord_of_the_Rings_RPG;


public class Item {
    private String name;
    private int value;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public Item(){

    }
    public Item(String name, int value){
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
