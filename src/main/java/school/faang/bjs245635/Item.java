package school.faang.bjs245635;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Item {
    private final String name;
    private final int value;

    private final static Logger logger = LoggerFactory.getLogger(Item.class);

    public Item(String name, int value) {
        if (name == null || name.trim().isEmpty() || value < 0) {
            logger.error("Invalid item name or value: {}, {} ", name, value);
            throw new IllegalArgumentException("Invalid item name or value");
        }
        this.name = name;
        this.value = value;
    }
}
