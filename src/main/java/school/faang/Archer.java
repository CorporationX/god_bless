package school.faang;

import lombok.EqualsAndHashCode;

public class Archer extends Character{
    private static final int power = 3;
    private static final int agility = 10;
    private static final int intelligence = 5;

    public Archer(String name) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }
}