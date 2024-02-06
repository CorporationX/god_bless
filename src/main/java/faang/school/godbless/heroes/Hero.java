package faang.school.godbless.heroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Hero {

    private String name;
    private String fraction;
    private int experience;
    private int level;
    private List<Creature> creatures = new ArrayList<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        int minionIndex = creatures.indexOf(creature);
        if (minionIndex >= 0) {
            creatures.get(minionIndex).setCount(creatures.get(minionIndex).getCount() + quantity);
        }
        else {
            creature.setCount(quantity);
            creatures.add(creature);
        }
    }

    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    public List<Creature> getArmy() {
        return creatures;
    }
}
