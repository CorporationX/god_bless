package faang.school.godbless.heroes_might_and_magic.entity.hero;

import faang.school.godbless.heroes_might_and_magic.entity.creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private List<Creature> army;
    private final int MAX_ARMY_SIZE = 10;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new ArrayList<>(MAX_ARMY_SIZE);
    }

    public void addCreature(Creature creature) {
        if(army.size() <= 10){
            army.add(creature);
        }else {
            throw new IndexOutOfBoundsException();
        }

    }

    public void removeCreature(Creature creature) {
        army.remove(creature);
    }

    public List<Creature> getArmy() {
        return army;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", army=" + army +
                '}';
    }
}

