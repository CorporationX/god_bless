package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            int currentQuantity = army.get(creature);
            if (currentQuantity <= quantity) {
                army.remove(creature);
            } else {
                army.put(creature, currentQuantity - quantity);
            }
        }
    }
}