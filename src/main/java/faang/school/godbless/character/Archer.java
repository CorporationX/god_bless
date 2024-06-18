package faang.school.godbless.character;

import lombok.NonNull;

public class Archer extends Character {

    private static final Integer DEFAULT_POWER = 3;
    private static final Integer DEFAULT_AGILITY = 10;
    private static final Integer DEFAULT_INTELLIGENCE = 5;

    public Archer(@NonNull String name) {
        super(name);
    }

    public Archer(@NonNull String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - DEFAULT_AGILITY);
    }
}
