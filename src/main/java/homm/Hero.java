package homm;

import homm.creatures.Creature;

import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    @NonNull
    private final String name;
    @NonNull
    private final String fraction;
    private int exp;
    private int level = 1;
    private final Map<Creature, Integer> creatures = new HashMap<>();

    public void addCreature(@NonNull Creature creature, int count) {
        if (count > creature.getCount()) {
            System.out.println("Limit to hire this creature is " + creature.getCount());
            count = creature.getCount();
        }
        creatures.put(creature, creatures.getOrDefault(creature, 0) + count);
    }

    public void removeCreature(@NonNull Creature creature, int count) {
        if (creatures.containsKey(creature)) {
            if (count > creatures.get(creature)) {
                count = creatures.get(creature);
            }
            creatures.put(creature, creatures.get(creature) - count);
            if (creatures.get(creature) == 0) {
                creatures.remove(creature);
            }
        } else {
            System.out.println("There is no such creature in the army");
        }
    }

    public int getDamage() {
        int damage = 0;
        for (Map.Entry<Creature, Integer> entry : creatures.entrySet()) {
            damage += entry.getValue() * entry.getKey().getDamage();
        }

        return damage;
    }

    public int getDefense() {
        int defense = 0;
        for (Map.Entry<Creature, Integer> entry : creatures.entrySet()) {
            defense += entry.getValue() * entry.getKey().getDefense();
        }

        return defense;
    }
    public void computeLevel(int exp) {
        this.exp += exp;
        while (this.exp >= this.level * 100) {
            this.exp -= this.level * 100;
            this.level++;
            System.out.println("Hero " + this.name + " of " + this.fraction + " reached level " + this.level + "!");
        }
    }
}
