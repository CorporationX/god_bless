package faang.school.godbless.javahashmap;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hero {
    private  String name;
    private  String fraction;
    private int experience;
    private int level;
    private List<Creature> army = new ArrayList<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        if (quantity <= 0) throw new IllegalStateException("Количество должно быть больше нуля");

        if (creature.getQuantity() == 0) {
            creature.setQuantity(quantity);
        } else {
            creature.setQuantity(creature.getQuantity() + quantity);
        }

        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (quantity <= 0) throw new IllegalStateException("Количество должно быть больше нуля");

        if (creature.getQuantity() - quantity < 0) {
            creature.setQuantity(0);
        } else {
            creature.setQuantity(creature.getQuantity() - quantity);
        }
    }

}
