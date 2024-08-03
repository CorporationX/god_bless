package faang.school.godbless.BJS2_18872;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class Hero {

    @Getter @Setter private String name;
    @Getter @Setter private String faction;
    @Getter @Setter private int experience;
    @Getter @Setter private int level;
    @Getter private HashMap<Creature, Integer>  army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = 1;
        this.army = new HashMap<>();
    }


    public void addCreature(Creature creature, int quantity) {
        if (army == null) {
            army = new HashMap<>();
            army.put(creature, quantity);
        } else {
            army.put(creature, army.getOrDefault(creature, 0) + quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army != null) {
            if (army.containsKey(creature)) {
                army.put(creature, army.get(creature) - quantity);
            }
        }
    }

    public int calculateTotalDamage() {
        int totalDamage = 0;
        for (Creature creature : army.keySet()) {
            totalDamage += army.get(creature) * creature.getDamage();
        }
        return totalDamage;
    }

}
