package school.faang.heroes_of_might_and_magic;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private static final Map<Creature, Integer> ARMORS = new HashMap<>();
    private final String name;
    private final String fraction;
    private final Integer experience;
    private final Integer level;

    public static void addCreature(Creature creature, int quantity) {
        if (creature == null || quantity <= 0) {
            throw new IllegalArgumentException("В методе addCreature: аргументы = null");
        }
        ARMORS.put(creature, quantity);
    }

    public static void removeCreature(Creature creature, int quantity) {
        if (creature == null || quantity <= 0) {
            throw new IllegalArgumentException("В методе removeCreature: аргументы = null");
        }
        ARMORS.remove(creature, quantity);
    }

    public static Map<Creature, Integer> getArmy() {
        return ARMORS;
    }
}
