package faang.school.godbless.task_1.Army;

import faang.school.godbless.task_1.Creature.Creature;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    @Getter
    protected String name;
    protected String fraction;
    protected int experience;
    protected int level;
    protected Map<Creature, Integer> heroArmy = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        if (heroArmy.containsKey(creature)) {
            int newQuantity = heroArmy.get(creature) + quantity;
            heroArmy.put(creature, newQuantity);
        } else {
            heroArmy.put(creature, quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (heroArmy.containsKey(creature)) {
            heroArmy.remove(creature, quantity);
        }
    }

    public Map<Creature, Integer> getArmy() {
        return heroArmy;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }
}
