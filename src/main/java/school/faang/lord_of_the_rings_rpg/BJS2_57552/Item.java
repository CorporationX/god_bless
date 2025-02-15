package school.faang.lord_of_the_rings_rpg.BJS2_57552;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class Item {
    private static final Logger LOGGER = LoggerFactory.getLogger(Item.class);

    private final String name;
    private int value;

    public Item(String name, int value) {
        validateString(name, "Name is null or empty");
        validateInt(value < 0, "Value is negative");

        this.name = name;
        this.value = value;

        LOGGER.info("Item created");
    }

    private static void validateInt(boolean value, String message) {
        if (value) {
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateString(String name, String message) {
        if (name == null || name.isEmpty()) {
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
    }
}
