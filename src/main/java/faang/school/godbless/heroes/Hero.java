package faang.school.godbless.heroes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@ToString
public class Hero {

    private String name;
    private String fraction;
    private int experience;
    private int level;
    private List<Creature> armyList;

    @Getter
    @Setter
    private boolean isDied;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.armyList = new LinkedList<>();
    }


    public void addCreature(Creature creature, int quantity) {
        if (creature.getQuantity() != 0) {
            creature.setQuantity(creature.getQuantity() + quantity);
        } else {
            creature.setQuantity(quantity);
        }

        armyList.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        creature.setQuantity(creature.getQuantity() - quantity);
        if (creature.getQuantity() <= 0) {
            armyList.remove(creature);
        }

        if (armyList.isEmpty()) {
            isDied = true;
        }
    }

    public List<Creature> getArmy() {
        return armyList;
    }
}