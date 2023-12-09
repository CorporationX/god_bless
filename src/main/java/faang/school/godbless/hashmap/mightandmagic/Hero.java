package faang.school.godbless.hashmap.mightandmagic;

import faang.school.godbless.hashmap.mightandmagic.creatures.Creature;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;

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
        this.army = new LinkedList<>();
    }

    public void addCreature(Creature creature) {
        if (this.army.contains(creature)) {
            this.army
                    .get(this.army.indexOf(creature))
                    .increaseQuantity(creature.getQuantity());
        } else {
            this.army.add(creature);
        }
    }

    public void addCreatures(Creature... creatures) {
        Arrays.stream(creatures).forEach(this::addCreature);
    }

    public void removeCreature(Creature creature) {
        if (this.army.contains(creature)) {
            Creature currentCreature = this.army.get(this.army.indexOf(creature));
            if (currentCreature.getQuantity() - creature.getQuantity() > 0) {
                currentCreature.reduceQuantity(creature.getQuantity());
            } else {
                this.army.remove(creature);
            }
        }
    }

}
