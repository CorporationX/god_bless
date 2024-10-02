package school.faang.Characters;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLECT = 3;

    @Override
    public void attack(Character defender) {
        defender.health -= DEFAULT_STRENGTH;
    }

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLECT);
    }
}
