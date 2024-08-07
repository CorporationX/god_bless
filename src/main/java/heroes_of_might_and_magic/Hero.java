package heroes_of_might_and_magic;

import heroes_of_might_and_magic.creatures.Creature;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Hero {
    private String name;
    private String fraction;
    private int level;
    private int experience;
    private List<Creature> army;

    public Hero(String name, String fraction, int level, int experience) {
        this.name = name;
        this.fraction = fraction;
        this.level = level;
        this.experience = experience;
        this.army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quanitiy) {
        army.addAll(Collections.nCopies(quanitiy, creature));
    }

    public void removeCreature(Creature creature, int quantity) {
        int i = 0;
        while (i < quantity) {
            army.remove(creature);
            i++;
        }
    }

}
