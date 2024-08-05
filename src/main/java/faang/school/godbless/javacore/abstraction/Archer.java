package faang.school.godbless.javacore.abstraction;

public class Archer extends Character {

    public static final int AGILITY = 10;
    private static final int STRENGTH = 3;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.agility);
    }
}
