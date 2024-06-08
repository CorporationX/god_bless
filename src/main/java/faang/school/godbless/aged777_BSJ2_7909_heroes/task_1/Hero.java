package faang.school.godbless.aged777_BSJ2_7909_heroes.task_1;

import faang.school.godbless.aged777_BSJ2_7909_heroes.task_1.creatures.Creature;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    private String name;

    private String fraction;

    private int experience;

    private int level;

    @Getter
    private Map<Creature, Integer> army = new HashMap<>();

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        army.remove(creature);
    }

}
