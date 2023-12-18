package faang.school.godbless.hashMap.task_1.Army;

import faang.school.godbless.hashMap.task_1.Creature.Creature;
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

    public void removeCreature(Creature creature, int damageQuantity) {
        if (heroArmy.containsKey(creature)) {

            int currentQuantity = creature.getHealth();
            int afterDamageQuantity = currentQuantity - damageQuantity;

            if (afterDamageQuantity <= 0) {
                heroArmy.remove(creature);
            } else {
                heroArmy.put(creature, afterDamageQuantity);
            }
        } else {
            System.out.println("Creature not found in Hero's army");
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
