package carry_got_fat;

public class Item {
    private final String name;
    private final int power;

    public Item(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", power=" + power +
                "}";
    }
}
