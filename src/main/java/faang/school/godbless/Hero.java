package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Hero {
    //
    private String name;
    private String fraction;
    private int exp;
    private int lvl;
    private Map<Creature, Integer> army;

    public String getName() {
        return name;
    }

    public Hero(String name, String fraction, int exp, int lvl, Map<Creature, Integer> army) {
        this.name = name;
        this.fraction = fraction;
        this.exp = exp;
        this.lvl = lvl;
        this.army = army;
    }

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        int currentQuantity = army.getOrDefault(creature, 0);
        if (currentQuantity > quantity) {
            army.put(creature, currentQuantity - quantity);
        } else {
            army.remove(creature);
        }
    }

    public List<Creature> getArmy() {
        List<Creature> result = new ArrayList<>();
        army.forEach((creature, quantity) -> {
            for (int i = 0; i < quantity; i++) {
                result.add(creature);
            }
        });
        return result;
    }
}
