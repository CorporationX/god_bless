package faang.school.godbless.heroesofmightandmagic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public void addCreature(Creature creature, int quantity) {
        if (army == null) {
            army = new HashMap<>();
        }
        army.put(creature, quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        army.merge(creature, -quantity, Integer::sum);
    }
}
