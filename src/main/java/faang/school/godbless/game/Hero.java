package faang.school.godbless.game;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String fraction;
    private String experience;
    private int level;
    private Map<Creature, Integer> army;

    public Hero(String name, String fraction, String experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        army.put(creature, quantity);
    }

    public void removeCreature(Creature creature) {
        army.remove(creature);
    }
}
