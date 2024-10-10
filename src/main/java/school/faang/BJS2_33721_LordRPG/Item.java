package school.faang.BJS2_33721_LordRPG;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        ValidationUtils.validateString(name, "Invalid name!");
        ValidationUtils.validatePositiveInteger(value, "Value can't be less or equal to 0!");
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Item's name: %s, its value: %d dollars", name, value);
    }
}
