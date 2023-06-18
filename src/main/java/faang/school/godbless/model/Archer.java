package faang.school.godbless.model;

import lombok.EqualsAndHashCode;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    protected void attack(Character character) {
        character.health -= strength;
    }
}
