package faang.school.godbless.lordRings;

import lombok.Getter;

@Getter
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        validateName(name);
        validateValue(value);
        this.name = name;
        this.value = value;
    }
    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be blank");
        }
    }

    private void validateValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value can't be negative.");
        }
    }
}
