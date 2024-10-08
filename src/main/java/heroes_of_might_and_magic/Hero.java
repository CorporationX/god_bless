package heroes_of_might_and_magic;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        army.put(creature, Math.max(0, army.getOrDefault(creature, 0) - quantity));
        if (army.get(creature) == 0) {
            army.remove(creature);
        }
    }
}
