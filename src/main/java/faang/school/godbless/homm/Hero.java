package faang.school.godbless.homm;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int lvl;
    private Set<Creature> squad;

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
        this.exp = 0;
        this.lvl = 1;
        this.squad = new HashSet<>();
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        squad.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (!squad.contains(creature)) {
            throw new IllegalArgumentException("no such creature in army");
        }
        int quantityInArmy = 0;
        for (Creature creatureInArmy : squad) {
            if (creatureInArmy.equals(creature)) {
                quantityInArmy = creatureInArmy.getQuantity();
                quantityInArmy -= quantity;
                if (quantityInArmy <= 0) {
                    squad.remove(creatureInArmy);
                } else {
                    creatureInArmy.setQuantity(quantityInArmy);
                }
            }
        }
    }

    public void getArmy() {
        for (Creature creatureInArmy : squad) {
            System.out.println(creatureInArmy);
        }
    }
}
