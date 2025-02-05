package school.faang.abstraction_abstraction;

public class Warrior extends Character {
    private static final int POWER = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getPower());
        healthCheck(opponent);
        printHealth(opponent);
    }
}
