package school.faang.abstraction_abstraction;

public class Archer extends Character {

    private static final int POWER = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        healthCheck(opponent);
        opponent.setHealth(opponent.getHealth() - this.getPower());
        healthOpponent(opponent);
    }
}
