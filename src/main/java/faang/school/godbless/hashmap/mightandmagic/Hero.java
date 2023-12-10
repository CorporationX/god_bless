package faang.school.godbless.hashmap.mightandmagic;

import faang.school.godbless.hashmap.mightandmagic.creatures.Creature;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Hero {

    private String name;
    private String fraction;
    private long experience;
    private int level;
    private LinkedList<Creature> army;

    public Hero(String name, String fraction, long experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        army = new LinkedList<>();
    }

    public void addCreature(Creature creature) {
        if (army.contains(creature)) {
            army.get(army.indexOf(creature))
                    .increaseQuantity(creature.getQuantity());
        } else {
            army.add(creature);
        }
    }

    public void addCreatures(Creature... creatures) {
        Arrays.stream(creatures).forEach(this::addCreature);
    }

    public void removeCreature(Creature creature) {
        int index = army.indexOf(creature);
        if (index != -1) {
            Creature currentCreature = army.get(index);
            if (currentCreature.getQuantity() - creature.getQuantity() > 0) {
                currentCreature.reduceQuantity(creature.getQuantity());
            } else {
                army.remove(creature);
            }
        }
    }

    public void removeDeadCreature(Creature creature) {
        army.remove(creature);
    }

}
