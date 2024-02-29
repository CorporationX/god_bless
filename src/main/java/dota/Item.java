package dota;

import java.util.Objects;

public class Item {
    private String name;
    private int power;

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
        return "Item{" + "name='" + name + '\'' + ", power=" + power + '}';
    }
}

