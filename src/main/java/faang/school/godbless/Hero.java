package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    protected Map<String, Creature> army = new HashMap<>();

    protected String name;
    protected String fraction;
    protected int experience;
    protected int level;

    public void addCreature(Creature creature, int quantity) {
        if (army.containsValue(creature)) {
            army.get(creature.getName()).setQuantity(army.get(creature.getName()).getQuantity() + quantity);
        } else army.put(creature.getName(), creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.containsValue(creature)) {
            army.get(creature.getName()).setQuantity(army.get(creature.getName()).getQuantity() - quantity);
        }

        if (army.get(creature.getName()).getQuantity() <= 0) {
            army.remove(creature);
            System.out.println(creature.getName() + " in " + this.name + "'s army ended");
        }
    }

    public List<Creature> getArmy() {
        List<Creature> creatures = new ArrayList<>();

        for (Creature creature : army.values()) {
            creatures.add(creature);
        }
        return creatures;
    }
}
