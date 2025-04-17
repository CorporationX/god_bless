package school.faang.abstraction;

public class Warrior extends Character {
    public static final int WARRIOR_STRENGTH = 10;
    public static final int WARRIOR_AGILITY = 10;
    public static final int WARRIOR_INTELLIGENCE = 10;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
}