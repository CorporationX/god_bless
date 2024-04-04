package faang.school.godbless.BJS2_4400;

public class Warrior extends Character {

    private static final int POWER = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;


    public Warrior(String name) {
        super(name);
    }

    public Warrior() {
        super(POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - POWER);
    }
}
