package school.faang.abstraction;

public class Warrior extends school.faang.abstraction.Character {

    private static final int ARCHER_STRENGTH = 10;
    private static final int ARCHER_AGILITY = 5;
    private static final int ARCHER_INTELLIGENCE = 3;

    public Warrior(String name) {

        super(ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE, name);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.getAgility());
    }
}
