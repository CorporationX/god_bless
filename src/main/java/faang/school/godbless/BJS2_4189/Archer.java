package faang.school.godbless.BJS2_4189;

public class Archer extends Character{

    private static final int POWER = 3;
    private static final int AGILITY = 10;
    private static final int INTELLECT = 5;

    public Archer(String name) {
        super(name, POWER, AGILITY, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth() - AGILITY;
        character.setHealth(health);
    }
}
