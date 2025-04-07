package school.faang.abstraction;

public class Archer extends Character {

    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_DEXTERITY = 10;
    private static final int DEFAULT_INTELLECT = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLECT);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.dexterity;
        checkHealth(opponent);
    }
}
