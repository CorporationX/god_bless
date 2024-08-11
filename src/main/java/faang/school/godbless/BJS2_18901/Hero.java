package faang.school.godbless.BJS2_18901;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            army.remove(creature);
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

