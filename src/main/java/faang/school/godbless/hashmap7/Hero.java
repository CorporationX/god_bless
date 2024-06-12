package faang.school.godbless.hashmap7;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Hero {
    public static final String ERROR = "Нет такого существа";
    private final String NAME;
    private final String FRACTION;
    private final int EXPERIENCE;
    private final int LVL;
    @Getter
    private final List<Creature> army;

    public Hero(String name, String fraction, int experience, int lvl) {
        this.NAME = name;
        this.FRACTION = fraction;
        this.EXPERIENCE = experience;
        this.LVL = lvl;
        this.army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.contains(creature)) {
            Creature creatureFromList = getCreatureFromList(creature);
            creatureFromList.setQuantity(creatureFromList.getQuantity() + quantity);
        } else {
            creature.setQuantity(quantity);
            army.add(creature);
        }
    }

    private Creature getCreatureFromList(Creature creature) {
        return army.get(army.lastIndexOf(creature));
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.contains(creature)) {
            Creature creatureFromList = getCreatureFromList(creature);
            if (creatureFromList.getQuantity() == quantity) {
                army.remove(creature);
            } else {
                creatureFromList.setQuantity(creatureFromList.getQuantity() - quantity);
            }
        } else {
            System.out.println(ERROR);
        }
    }
}
