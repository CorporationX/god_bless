package faang.school.godbless.task_12;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int level;
    private final Map<Creature, Integer> army = new HashMap<>();

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (!army.containsKey(creature)) {
            return;
        }
        army.put(creature, army.get(creature) - quantity);
        if (army.get(creature) <= 0) {
            army.remove(creature);
        }
    }
}
