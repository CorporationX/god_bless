package faang.school.godbless.BJS2_18970;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String fraction;
    private int skill;
    private int level;

    private List<Creature> army = new ArrayList<>();

    public Hero(String name, String fraction, int skill, int level) {
        this.name = name;
        this.fraction = fraction;
        this.skill = skill;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            army.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        for (int i = quantity; i > 0; i--) {
            army.remove(creature);
        }
    }

    List<Creature> getArmy() {
        return this.army;
    }
}
