package school.faang.BJS2_56484;

public class Archer extends Character {
    private static final int CH_POWER = 3;
    private static final int CH_AGILITY = 10;
    private static final int CH_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, CH_POWER, CH_AGILITY, CH_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.hasHealth()) {
            opponent.setHealth(opponent.getHealth() - getAgility());
        } else {
            System.out.println("Противник " + opponent.getName() + " повержен!");
        }
    }

}
