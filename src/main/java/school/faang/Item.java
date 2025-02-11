package school.faang;

import lombok.Getter;

@Getter
public class Item {
    private final String name;
    private final int value;

    public Item(String name, int value) {
        validateName(name);
        validateValue(value);
        this.name = name;
        this.value = value;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name can't be null or empty. Provided value" + name);
        }
    }

    private void validateValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("The value can't be less than 0.");
        }
    }
}
