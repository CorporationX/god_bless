package school.faang.bjs269209.classes;

import school.faang.bjs269209.Character;

public class Warrior extends Character {
    public static final int BASE_STRENGTH_VALUE = 10;
    public static final int BASE_INTELLIGENCE_VALUE = 3;

    public Warrior(String name) {
        super(name);
        this.strength = BASE_STRENGTH_VALUE;
        this.intelligence = BASE_INTELLIGENCE_VALUE;
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(this.strength);
    }
}
