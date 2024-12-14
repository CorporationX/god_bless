package school.faang.task_43830;

public class Warrior extends Character {

    private static final int WARRIOR_POWER = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character player) {
        player.setHealth(player.getHealth() - this.getPower());
    }
}
