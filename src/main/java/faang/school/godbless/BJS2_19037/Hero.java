package faang.school.godbless.BJS2_19037;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Hero {
    private static final int MAX_ARMY_SIZE = 7;

    private String name;
    private String fraction;
    private int experience;
    private int level;
    @Getter
    private List<Creature> army = new ArrayList<>(MAX_ARMY_SIZE);

    public Hero(String name, String fraction, int experience, int level) {
        Validator.validateNotEmpty(name, "Name");
        Validator.validateNotEmpty(fraction, "Fraction");
        Validator.validateNonNegative(experience, "Experience");
        Validator.validatePositive(level, "Level");
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature) {
        if (this.army.size() < MAX_ARMY_SIZE) {
            this.army.add(creature);
        } else {
            throw new IllegalStateException("Army is full");
        }
    }

    public void removeCreature(Creature creature) {
        this.army.remove(creature);
    }

    public boolean isDefeated() {
        return this.army.isEmpty();
    }
}
