package faang.school.godbless.LordOfTheRings;

import lombok.Data;

@Data
public class Item {
    private String name;
    private int value;

    Item(String name, int value) {
        if (name == null || name.isEmpty() || value < 0) {
            throw new IllegalArgumentException("Name cannot be null or empty and value cannot be negative");
        }
        this.name = name;
        this.value = value;
    }

    public void update(Item newItem) {
        this.name = newItem.name;
        this.value = newItem.value;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Value: " + value;
    }
}
