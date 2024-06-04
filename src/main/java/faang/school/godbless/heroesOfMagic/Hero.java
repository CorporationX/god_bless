package faang.school.godbless.heroesOfMagic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Hero {

    private String name;
    private String fraction;
    private Integer experience;
    private Integer level;
    private final List<Creature> army = new ArrayList<>();

    public void addCreature(Creature creature, Integer quantity) {
        if (creature != null && (creature.getQuantity() != null || quantity != null)) {
            Creature creatureForSaving = creature
                    .createInstance((creature.getQuantity() == null) ? quantity : quantity + creature.getQuantity());

            army.add(creatureForSaving);
        }
    }

    public void removeCreature(Creature creature, Integer quantity) {
        if (creature != null && (creature.getQuantity() != null || quantity != null)) {
            Creature creatureForLooking = creature.createInstance((creature.getQuantity() == null) ? quantity : quantity + creature.getQuantity());

            army.forEach(c -> {
                if (creatureForLooking.getName().equals(c.getName())
                        && creatureForLooking.getLevel().equals(c.getLevel())
                        && creatureForLooking.getAttack().equals(c.getAttack())
                        && creatureForLooking.getDefence().equals(c.getDefence())
                        && creatureForLooking.getSpeed().equals(c.getSpeed())) {
                    if (creatureForLooking.getQuantity() >= c.getQuantity()) {
                        army.remove(c);
                    } else {
                        c.setQuantity(c.getQuantity() - creatureForLooking.getQuantity());
                    }
                }
            });
        }
    }
}
