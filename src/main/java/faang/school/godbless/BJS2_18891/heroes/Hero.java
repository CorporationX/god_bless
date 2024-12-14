package faang.school.godbless.BJS2_18891.heroes;

import faang.school.godbless.BJS2_18891.units.Creature;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Hero {

    private String name;

    public Hero(String name) {
        this.name = name;
    }

    private final Map<Creature, Integer> army = new HashMap<>();

    public void addCreature(Creature creature, Integer quantity) {
        if (!army.containsKey(creature)) {
            army.put(creature, quantity);
        } else {
            army.put(creature, army.get(creature) + quantity);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
