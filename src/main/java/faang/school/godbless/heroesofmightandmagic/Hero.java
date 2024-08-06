package faang.school.godbless.heroesofmightandmagic;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private static final int MAX_ARMY_SIZE = 7;
    private String name;
    private String fraction;
    private int experience;
    private int level;
    @Getter
    private List<Creature> army;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new ArrayList<>(MAX_ARMY_SIZE);
    }

    public void addCreature(Creature creature) {
        if (army.size() < MAX_ARMY_SIZE) {
            army.add(creature);
        } else {
            throw new IllegalStateException("Too many creatures in" + name + "army");
        }
    }

    public void removeCreature(Creature creature) {
        army.remove(creature);
    }

    public boolean isDefeated() {
        return army.isEmpty();
    }
}