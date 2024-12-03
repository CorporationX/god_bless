package school.faang.sprint_1.task_bjs243837;

public class Archer extends Character {
    private static final int STRENGTH = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
    }
}
