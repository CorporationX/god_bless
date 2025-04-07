package school.faang.abstraction;

public class Warrior extends Character {
    private static final int STRENGTH_VALUE_DEFAULT = 10;
    private static final int AGILITY_VALUE_DEFAULT = 5;
    private static final int INTELLECT_VALUE_DEFAULT = 3;

    public Warrior(String name) {
        super(name, STRENGTH_VALUE_DEFAULT, AGILITY_VALUE_DEFAULT, INTELLECT_VALUE_DEFAULT);
    }

    @Override
    public void attack(Character opponent) {
        reduceHealth(opponent, this.strength);
    }
}
