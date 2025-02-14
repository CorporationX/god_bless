package school.faang.naughtwoBJS257533;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String itemName;
    private int value;

    public Item(String itemName, int value) {
        checkItemName(itemName);
        checkValue(value);
        this.itemName = itemName;
        this.value = value;
    }

    private void checkItemName(String itemName) {
        if (itemName == null || itemName.isBlank()) {
            throw new IllegalArgumentException("Item name cannot be 'null' or empty.");
        }
    }

    private void checkValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be less than zero");
        }
    }
}
