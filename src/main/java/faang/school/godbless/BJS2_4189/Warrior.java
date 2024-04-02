package faang.school.godbless.BJS2_4189;

public class Warrior extends Character {

    private static final int POWER = 10;
    private static final int AGILITY = 5;
    private static final int INTELLECT = 3;

    public Warrior(String name) {
        super(name, POWER, AGILITY, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth() - POWER;
        character.setHealth(health);
    }

}
