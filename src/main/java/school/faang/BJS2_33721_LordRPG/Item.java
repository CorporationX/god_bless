package school.faang.BJS2_33721_LordRPG;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        validateString(name, "Invalid name!");
        validateValue(value);
        this.name = name;
        this.value = value;
    }

    private void validateString(String info, String message) {
        if (info == null || info.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Invalid value! Must be more than 0.");
        }
    }
}
