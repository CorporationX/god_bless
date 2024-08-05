package faang.school.godbless.javacore.abstraction;

public class Warrior extends Character {

    public static final int STRENGTH = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.strength);
    }
}
