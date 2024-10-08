package dima.evseenko.heroes;

import dima.evseenko.heroes.entity.Creature;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Hero {
    private final List<Creature> army = new ArrayList<>();

    private String name;
    private Fraction fraction;
    private float experience;
    private int level;

    public void addCreature(Creature creature, int quantity) {
        if (Objects.nonNull(creature) && quantity > 0) {
            for (int i = 0; i < quantity; i++) {
                try {
                    army.add((Creature) creature.clone());
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void deleteCreature(Creature creature, int quantity) {
        if (Objects.nonNull(creature) && quantity > 0) {
            for (int i = 0; i < quantity; i++) {
                army.remove(creature);
            }
        }
    }


}
