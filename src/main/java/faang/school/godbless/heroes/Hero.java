package faang.school.godbless.heroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Hero {

    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setCount(quantity);
        army.putIfAbsent(creature, quantity);
    }

    public void removeCreature(Creature creature) {
        army.remove(creature);
    }

    public List<Creature> getArmy() {
        return new ArrayList<>(army.keySet());
    }
}
