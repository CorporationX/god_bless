package faang.school.godbless.model;

import lombok.EqualsAndHashCode;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    protected void attack(Character character) {
        if (character.health - strength >= 0)
            character.health -= strength;
    }
}
