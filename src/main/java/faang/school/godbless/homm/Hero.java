package faang.school.godbless.homm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    private Map<Creature, Integer> army = new HashMap<>();
    private String name;
    private String fraction;
    private int experience;
    private int lavel;

    public Hero(String name, String fraction, int experience, int lavel) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.lavel = lavel;
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setCount(quantity);
        army.put(creature, quantity);
    }

    public void removeCreature(Creature creature) {
        army.remove(creature);
    }

    public List<Creature> getArmy() {
        List<Creature> allArmy = new ArrayList<>();
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            allArmy.add(entry.getKey());

        }
        return allArmy;

    }

    public String getName() {
        return name;
    }
}
