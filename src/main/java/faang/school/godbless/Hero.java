package faang.school.godbless;

import faang.school.godbless.creation.Creature;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> heroArmy = new HashMap<>();

    public Hero(String name, String fraction, int level, int experience) {
        this.name = name;
        this.fraction = fraction;
        this.level = level;
        this.experience = experience;
    }

    public Map<Creature, Integer> addCreature(Creature creature, int quantity) {
        if(creature == null || quantity == 0) {
            throw new IllegalArgumentException();
        }
        if(heroArmy.containsKey(creature)) {
            heroArmy.put(creature, heroArmy.get(creature) + quantity);
        } else {
            heroArmy.put(creature, quantity);
        }
        return heroArmy;
    }

    public Map<Creature, Integer> removeCreature(Creature creature, int quantity) {
        if(creature == null || quantity == 0) {
            throw new IllegalArgumentException();
        }
        if(heroArmy.containsKey(creature)) {
            heroArmy.put(creature, heroArmy.get(creature) - quantity);
        } else {
            throw new IllegalArgumentException();
        }
        return heroArmy;
    }
}
