package school.faang.task_43830;

public class Archer extends Character {

    private static final int ARCHER_POWER = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;
    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character player) {
        player.setHealth(player.getHealth() - this.getAgility());
    }
}
