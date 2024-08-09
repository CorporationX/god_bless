package faang.school.godbless.BJS2_18872;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class Hero {

    private String name;
    private String faction;
    private int experience;
    private int level;

    @Setter(AccessLevel.NONE)
    private Map<Creature, Integer> army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = 1;
        this.army = new HashMap<>();
    }


    public void addCreature(Creature creature, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        if (army == null) {
            army = new HashMap<>();
        }

        army.merge(creature, quantity, Integer::sum);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (quantity <= 0 || quantity > army.get(creature)) {
            throw new IllegalArgumentException("Quantity must be greater than 0 and less than or equal to " + army.get(creature));
        } else if (creature == null) {
            throw new IllegalArgumentException("Creature cannot be null");
        }

        if (army != null && army.containsKey(creature)) {
                army.put(creature, army.get(creature) - quantity);
        }

    }

    public int calculateTotalDamage() {
        int totalDamage = 0;
        for (Creature creature : army.keySet()) {
            totalDamage += army.get(creature) * creature.getDamage();
        }
        return totalDamage;
    }

    @Override
    public String toString() {
        StringBuilder armyString = new StringBuilder();
        for (Map.Entry<Creature, Integer> armyEntry : army.entrySet()) {
            armyString.append(armyEntry.getKey().getName())
                    .append(": ")
                    .append(armyEntry.getValue())
                    .append("\n");
        }
        return "Hero: " + name + ", Faction: " + faction + ", Exp: " + experience + ", Lvl: " + level + "\n" +
                "Has army: \n" + armyString.toString();
    }

}
