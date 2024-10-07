package HeroesOfMightAndMagic;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private final Map<Creature, Integer> ARMY = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        ARMY.put(creature, ARMY.get(creature) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (ARMY.get(creature) - quantity <= 0) {
            ARMY.remove(creature);
        } else {
            ARMY.put(creature, ARMY.get(creature) - quantity);
        }
    }

    public void getArmy() {
        ARMY.forEach((creature, quantity) -> {
            System.out.println(creature + ": " + quantity);
        });
    }

    public long getArmyDamage() {
        long finalDamage = 0;

        for (Map.Entry<Creature, Integer> entry : ARMY.entrySet()) {
            finalDamage += (long) entry.getValue() * entry.getKey().getDamage();
        }

        return finalDamage;
    }
}
