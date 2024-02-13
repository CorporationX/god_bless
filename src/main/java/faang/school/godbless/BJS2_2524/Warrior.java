package faang.school.godbless.BJS2_2524;

import lombok.NonNull;

public class Warrior extends Character {
    private static final Integer DEFAULT_STRENGTH = 10;
    private static final Integer DEFAULT_AGILITY = 5;
    private static final Integer DEFAULT_INTELLIGENCE = 3;

    public Warrior(@NonNull String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character other) {
        other.reduceHealth(this.getStrength());
    }
}
