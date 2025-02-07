package school.faang.task_56473;

public class Archer extends Character {

    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {

        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (isAlive(this.getHealth())) {
            opponent.setHealth(opponent.getHealth() - this.getAgility());
            healthLevelCheck(opponent);
        }
    }
}
