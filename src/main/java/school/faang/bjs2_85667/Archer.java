package school.faang.bjs2_85667;

public class Archer extends Character {

    private static final int POWER = 3;
    private static final int DEXTERITY = 3;
    private static final int INTELLIGENCE = 3;

    public Archer(String name) {
        super(name, POWER, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getDexterity());
    }
}