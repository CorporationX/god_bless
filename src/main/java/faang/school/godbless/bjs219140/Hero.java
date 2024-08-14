package faang.school.godbless.bjs219140;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        army.compute(creature, (key, existingQuantity) -> {
            if (existingQuantity == null) {
                return quantity;
            } else {
                return existingQuantity + quantity;
            }
        });
    }

    public void removeCreature(Creature creature, int quantity) {
        army.computeIfPresent(creature, (key, existingQuantity) -> {
            if (existingQuantity - quantity <= 0) {
                army.remove(creature);
            }
           return existingQuantity - quantity;
        });
    }
}
