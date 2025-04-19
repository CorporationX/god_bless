package school.faang.bjs2_69381;

public class Warrior extends Character {
    private static final int DEFAULT_POWER = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_POWER, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(strength);
    }
}