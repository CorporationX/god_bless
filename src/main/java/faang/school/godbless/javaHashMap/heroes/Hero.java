package faang.school.godbless.javaHashMap.heroes;

import faang.school.godbless.javaHashMap.heroes.creatures.Creature;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Hero {
    private final String name;
    private final String fraction;
    private int exp;
    private int mana;
    private int lvl;

    private final Map<Creature, Integer> army;

    public Hero(String name, String fraction, int lvl, int mana) {
        this.name = name;
        this.fraction = fraction;
        this.lvl = lvl;
        exp = 0;
        this.mana = mana;

        army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (mana < quantity * creature.getManaCost()) {
            throw new RuntimeException("Not enough mana to summon these creatures (" +
                    quantity + " " + creature.getName() + ")!");
        }

        army.put(creature, army.computeIfAbsent(creature, key -> 0) + quantity);
        mana -= quantity * creature.getManaCost();
    }

    public void removeCreature(Creature creature, int quantityToBeRemoved) {
        if (army.containsKey(creature)) {
            var currentQuantity = army.get(creature);
            if (currentQuantity < quantityToBeRemoved) {
                army.remove(creature);
                return;
            }

            army.put(creature, currentQuantity - quantityToBeRemoved);
        }
    }

    public void showArmy() {
        System.out.println("\nThe hero " + name + " has in his (her) army:");
        army.forEach((creature, quantity) -> {
            System.out.println(creature.getName() + " in count of " + quantity + " units;");
        });

        System.out.println();
    }
}
