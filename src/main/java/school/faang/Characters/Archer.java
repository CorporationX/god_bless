package school.faang.Characters;

public class Archer extends Character {
    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLECT = 5;

    @Override
    public void attack(Character defender) {
        defender.health -= DEFAULT_AGILITY;
    }

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLECT);
    }
}
