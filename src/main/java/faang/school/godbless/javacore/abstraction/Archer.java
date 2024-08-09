package faang.school.godbless.javacore.abstraction;

public class Archer extends Character {

    public static final int AGILITY = 10;
    private static final int STRENGTH = 3;
    private static final int INTELLIGENCE = 5;
    private static final int DAMAGE = AGILITY;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE, DAMAGE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= damage;
        checkHealth();
    }
}
