package school.faang.abstraction_abstraction.BJS2_56401;

public class Warrior extends Character {

    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        this.strength = WARRIOR_STRENGTH;
        this.intelligence = WARRIOR_INTELLIGENCE;
    }

    @Override
    public void attack(Character opponent) {
        if (opponent == null) {
            throw new NullPointerException(opponent + " is null");
        }
        opponent.setHealth(opponent.getHealth() - getStrength());
    }

}
