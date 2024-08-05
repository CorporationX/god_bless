package faang.school.godbless.BJS2_18901;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public void addCreature(Creature creature, int quantity) {
        if (army.isEmpty()) {
            army = new HashMap<>();
            army.put(creature, quantity);
        } else {
            throw new IllegalArgumentException("All good");
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (quantity > 0) {
            army.remove(creature, quantity);
        }
    }

    public int calculeteTotalDamage() {
        int totalDamage = 0;
        for (Creature creature : army.keySet()) {
            totalDamage += army.get(creature) * creature.getDamage();
        }
        return totalDamage;
    }
}
