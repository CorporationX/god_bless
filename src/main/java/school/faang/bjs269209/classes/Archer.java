package school.faang.bjs269209.classes;

import school.faang.bjs269209.Character;

public class Archer extends Character {
    public static final int BASE_STRENGTH_VALUE = 3;
    public static final int BASE_AGILITY_VALUE = 10;

    public Archer(String name) {
        super(name);
        this.strength = BASE_STRENGTH_VALUE;
        this.agility = BASE_AGILITY_VALUE;
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(this.agility);
    }
}
