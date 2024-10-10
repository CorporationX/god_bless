package HeroesOfMightAndMagic;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private final Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        if (creature != null) {
            army.put(creature, army.get(creature) + quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.get(creature) - quantity <= 0) {
            army.remove(creature);
        } else {
            army.put(creature, army.get(creature) - quantity);
        }
    }

    public void getArmy() {
        army.forEach((creature, quantity) -> {
            System.out.println(creature + ": " + quantity);
        });
    }

    public long getArmyDamage() {
        long finalDamage = 0;

        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            finalDamage += (long) entry.getValue() * entry.getKey().getDamage();
        }

        return finalDamage;
    }
}
