package school.faang.abstraction;

public class Archer extends Character {
    public static final int ARCHER_STRENGTH = 3;
    public static final int ARCHER_AGILITY = 10;
    public static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
    }
}