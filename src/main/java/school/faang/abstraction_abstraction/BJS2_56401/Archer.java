package school.faang.abstraction_abstraction.BJS2_56401;

public class Archer extends Character {

    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_DEXTERITY = 10;

    public Archer(String name) {
        super(name);
        this.strength = ARCHER_STRENGTH;
        this.dexterity = ARCHER_DEXTERITY;
    }

    @Override
    public void attack(Character opponent) {
        if (opponent == null) {
            throw new NullPointerException(opponent + " is null");
        }
        opponent.setHealth(opponent.getHealth() - getDexterity());
    }
}
