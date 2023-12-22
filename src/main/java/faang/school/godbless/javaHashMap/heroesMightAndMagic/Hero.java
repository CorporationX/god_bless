package faang.school.godbless.javaHashMap.heroesMightAndMagic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;

    Map<Creature,Integer> army;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }
    public void addCreature(Creature creature, int quantity) {
        if (army == null) {
            army = new HashMap<>();
        }

        if (quantity > 0) {
            army.putIfAbsent(creature, 0);
            army.put(creature, army.get(creature) + quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        int countCreature = army.get(creature);
        if (countCreature - quantity > 0) {
            army.put(creature, countCreature - quantity);
        } else {
            army.remove(creature);
        }
    }

    public List<Creature> getArmy() {
        List<Creature> armyByItem = new ArrayList<>();
        for (Map.Entry<Creature,Integer> creature : army.entrySet()) {
            for (int i = 0; i < creature.getValue(); i++) {
                armyByItem.add(creature.getKey());
            }
        }
        return armyByItem;
    }
}
