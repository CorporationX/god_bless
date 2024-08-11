package faang.school.godbless.BJS2_19094;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Hero {
    @Getter
    private final String name;
    private final String faction;
    private final int experience;
    private final int level;

    @Getter
    private Map<String, Army> army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = 1;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        String creatureName = creature.name;
        if (army.containsKey(creatureName)) {
            army.get(creatureName).addQuantity(quantity);
        } else {
            army.put(creatureName, new Army(creature, quantity));
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        String creatureName = creature.name;
        if (army.containsKey(creatureName)) {
            Army unit = army.get(creatureName);
            unit.removeQuantity(quantity);
            if (unit.getQuantity() <= 0) {
                army.remove(creatureName);
            }
        }
    }
}
