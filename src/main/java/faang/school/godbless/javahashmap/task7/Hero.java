package faang.school.godbless.javahashmap.task7;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
@ToString
public class Hero {

    private static final int MAX_SIZE_ARMY = 7;

    private String name;
    private String fraction;
    private Integer experience = 0;
    private Integer level = 1;
    private Integer aliveCreatures = 0;
    private final List<Creature> creatures = new ArrayList<>(MAX_SIZE_ARMY);
    private boolean isDefeated = false;

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
    }

    public Creature addCreature(Creature creature, int quantity) {
        int indexCreature = creatures.indexOf(creature);
        if (indexCreature < 0) {
            aliveCreatures++;
            creature.setQuantity(quantity);
            creatures.add(creature);
            return creature;
        } else if (creatures.size() <= MAX_SIZE_ARMY) {
            throw new IllegalStateException("Army " + name + " is full");
        } else {
            creatures.get(indexCreature).setQuantity(creatures.get(indexCreature).getQuantity() + quantity);
            return creatures.get(indexCreature);
        }
    }

    public Creature removeCreature(Creature creature, int quantity) {
        int indexCreature = creatures.indexOf(creature);
        if (indexCreature < 0) {
            return null;
        }

        Creature creatureCurrent = creatures.get(indexCreature);
        int remainingQuantity = creatureCurrent.getQuantity() - quantity;

        if (remainingQuantity <= 0) {
            aliveCreatures--;
            if (aliveCreatures == 0) {
                isDefeated = true;
            }
            return creatures.remove(indexCreature);
        } else {
            creatures.get(indexCreature).setQuantity(creatures.get(indexCreature).getQuantity() - quantity);
            return creatures.get(indexCreature);
        }
    }

    public List<Creature> getArmy() {
        return creatures;
    }
}
