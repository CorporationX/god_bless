package school.faang.task_45560;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
    private static final double MIN_SUM = 0.0;
    private String name;
    private double value;

    public Item(String name, double value) {
        validateName(name);
        validateValue(value);

        this.name = name;
        this.value = value;
    }

    private static void validateValue(double value) {
        if (value <= MIN_SUM) {
            throw new IllegalArgumentException("Value must be > " + MIN_SUM);
        }
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name don't be null or blank!");
        }
    }
}
