package school.faang.bjs245635;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private static final Logger logger = LoggerFactory.getLogger(Character.class);

    private final List<Item> inventory;
    private final String name;

    public Character(String name) {
        if (name == null || name.trim().isEmpty()) {
            logger.error("Invalid Character name : {} ", name);
            throw new IllegalArgumentException("Invalid Character name");
        }
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
