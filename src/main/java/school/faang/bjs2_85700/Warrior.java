package school.faang.bjs2_85700;

public class Warrior extends Character {

    private static final int WARRIOR_DEFAULT_STRENGTH = 10;
    private static final int WARRIOR_DEFAULT_AGILITY = 5;
    private static final int WARRIOR_DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_DEFAULT_STRENGTH, WARRIOR_DEFAULT_AGILITY, WARRIOR_DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent != null) {
            opponent.takeDamage(getStrength());
        } else {
            throw new IllegalArgumentException("Противник не может быть null.");
        }
    }
}
