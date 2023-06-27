package faang.school.godbless.lord_of_the_Rings_RPG;

import java.util.Objects;

public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return value == item.value && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        int num = 31;
        return num * Objects.hash(name, value);
    }
}
