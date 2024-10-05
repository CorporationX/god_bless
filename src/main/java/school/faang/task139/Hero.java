package school.faang.task139;

import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class Hero {

    private final HashMap<Creature, Integer> unions = new HashMap<>();
    private String name;
    private String fraction;
    private int experience;
    private int level;

    public void addCreature(Creature creature, int quantity) {
        unions.merge(creature, quantity, Integer::sum);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (unions.containsKey(creature)) {
            unions.put(creature, unions.get(creature) - quantity);
            if (unions.get(creature) <= 0) unions.remove(creature);
        }
    }

    public HashMap<Creature, Integer> getArmy() {
        return unions;
    }
}
