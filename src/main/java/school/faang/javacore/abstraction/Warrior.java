package school.faang.javacore.abstraction;

public class Warrior extends Character {

    public static final int DEFAULT_STRENGTH = 10;
    public static final int DEFAULT_DEXTERITY = 5;
    public static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
}
