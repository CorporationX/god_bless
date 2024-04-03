package faang.school.godbless.heroes_of_might_and_Magic;

import faang.school.godbless.heroes_of_might_and_Magic.unit.Creature;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String fraction;
    private int xp;
    private int level;
    private Map<Creature, Integer> army;

    public Hero(String name, String fraction, int xp, int level) {
        this.name = name;
        this.fraction = fraction;
        this.xp = xp;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) - quantity);
        if (army.get(creature) <= 0) {
            army.remove(creature);
        }
    }

}
