package faang.school.godbless.BJS2_2524;

import lombok.NonNull;

public class Archer extends Character {
    private static final Integer DEFAULT_STRENGTH = 3;
    private static final Integer DEFAULT_AGILITY = 10;
    private static final Integer DEFAULT_INTELLIGENCE = 5;

    public Archer(@NonNull String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character other) {
        other.reduceHealth(this.getAgility());
    }
}
