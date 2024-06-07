package faang.school.godbless;

import faang.school.godbless.creatures.Creature;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Hero {
    @Getter
    private static final Map<Creature, Integer> army = new HashMap<>();

    private String name;
    private String fraction;
    private int experience;
    private int level;


    public void addCreature(Creature creature, int quantity) {
        if (quantity > 0) {
            army.put(creature, quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            if (quantity > army.get(creature)) {
                army.remove(creature);
            } else {
                army.put(creature, quantity - army.get(creature));
            }
        }
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", fraction='" + fraction + '\'' +
                '}';
    }
}
