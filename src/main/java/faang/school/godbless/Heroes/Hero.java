package faang.school.godbless.Heroes;

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
    private Map<Creature, Integer> army;

    public Hero(String name, String faction, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)){
            int currentQuantity = army.get(creature);
            if (currentQuantity <= quantity){
                army.remove(creature);
            }
            else {
                 army.put(creature, currentQuantity - quantity);
            }
        }
    }

    public int getTotalArmyDamage() {
        int totalDamage = 0;
        for (Map.Entry<Creature, Integer> pair : army.entrySet()) {
            totalDamage += pair.getKey().getDamage() * pair.getValue();
        }
        return totalDamage;
    }

    @Override
    public String toString() {
        return String.format("%s (Faction: %s, Level: %d, Experience: %d)", name, faction, level, experience);
    }
}
