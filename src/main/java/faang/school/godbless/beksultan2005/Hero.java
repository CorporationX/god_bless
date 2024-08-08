package faang.school.godbless.beksultan2005;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Hero {
    private String name;
    private Map<Creature, Integer> faction;
    private int experience;
    private int level;

    public Hero(String name, int experience, int level) {
        this.name = name;
        this.faction = new HashMap<>();
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        if (faction.containsKey(creature)) {
            faction.put(creature, faction.get(creature) + quantity);
        } else {
            faction.put(creature, quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (faction.containsKey(creature)) {
            if (faction.get(creature) >= quantity) {
                faction.put(creature, faction.get(creature) - quantity);
                if (faction.get(creature) == 0) {
                    faction.remove(creature);
                }
            }
        }
    }

    public void getArmy() {
        System.out.println("Army " + getName() + ":");
        faction.forEach((key, value) -> System.out.println(key.getName() + ":" + value));
    }
}
