package faang.school.godbless.character;

import lombok.NonNull;

public class Warrior extends Character {

    private static final Integer DEFAULT_POWER = 10;
    private static final Integer DEFAULT_AGILITY = 5;
    private static final Integer DEFAULT_INTELLIGENCE = 3;

    public Warrior(@NonNull String name) {
        super(name);
    }

    public Warrior(@NonNull String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - DEFAULT_POWER);
    }
}
