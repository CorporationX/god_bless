package faang.school.godbless.javahashmap.herouse;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Hero {
    private static final int MAX_ARMY_SIZE = 7;
    private static Random RANDOM = new Random();

    @Getter
    private final String name;
    private final String fracture;
    private final int experience;
    private final int level;
    @Getter
    private final Map<Creature, Integer> army = new HashMap<>(MAX_ARMY_SIZE);

    public Hero(String name, String fracture, int experience, int level) {
        this.name = name;
        this.fracture = fracture;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.size() >= MAX_ARMY_SIZE) {
            throw new IllegalArgumentException("Army is full {name = " + name + "}.");
        }
        army.compute(creature, (key, value) -> value == null ? quantity : value + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (!army.containsKey(creature)) {
            throw new IllegalArgumentException("Hero {" + name + "} does not have " + creature.getName() + ".");
        }

        Integer currentQuantity = army.get(creature);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Hero {" + name + "} does not have enough " + creature.getName() + " to remove.");
        } else if (army.get(creature) == quantity) {
            army.remove(creature);
        } else {
            army.put(creature, currentQuantity - quantity);
        }
    }

    @SuppressWarnings("unchecked")
    public Map.Entry<Creature, Integer> getRandomCreature() {
        Random generator = new Random();
        Object[] keys = army.entrySet().toArray();
        return (Map.Entry<Creature, Integer>) keys[generator.nextInt(keys.length)];
    }

    public boolean isArmyEmpty() {
        return army.isEmpty();
    }
}
