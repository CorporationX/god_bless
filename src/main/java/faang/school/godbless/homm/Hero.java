package faang.school.godbless.homm;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    protected String name;
    protected int hp = 100;
    private final Map<String, Creature> allies = new HashMap<>();

    public Hero(String name) {
        this.name = name;
    }

    public void addCreature(Creature creature, int quantity) {

        if (!allies.containsKey(creature.name)) {
            switch (creature.name) {
                case "Swordsman" -> allies.put(creature.name, new Swordsman());
                case "Deadman" -> allies.put(creature.name, new Deadman());
                case "Dragon" -> allies.put(creature.name, new Dragon());
            }
        }

        allies.get(creature.name).quantity += quantity;
    }

    public void removeCreature(Creature creature, int quantity) {
        if (allies.containsKey(creature.name)) {
            allies.get(creature.name).quantity = Math.max(allies.get(creature.name).quantity - quantity, 0);

            if (allies.get(creature.name).quantity == 0) {
                allies.remove(creature.name);
            }
        }
    }

    public Map<String, Creature> getArmy() {
        return allies;
    }
}
