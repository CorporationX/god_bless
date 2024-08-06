package faang.school.godbless.BJS2_18911;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Hero {

    private String name;
    private String fraction;
    private int experience;
    private int level;
    private int bonus;
    private List<Creature> army;

    public Hero(String name, String fraction, int experience, int level) {
        this(name, fraction, experience, level, new ArrayList<>());
    }

    public Hero(String name, String fraction, int experience, int level, List<Creature> army) {
        if (experience < 0 || experience > 1000 || level < 0 || level > 100) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = army;
        this.bonus = (level * 100 + experience) / 500;
    }

    public void addCreature(Creature creature, int quantity) {
        if (quantity == 0) {
            throw new IllegalArgumentException();
        }
        while (quantity-- != 0) {
            army.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (quantity == 0) {
            throw new IllegalArgumentException();
        }
        while (quantity-- != 0) {
            army.remove(creature);
        }
    }
}
