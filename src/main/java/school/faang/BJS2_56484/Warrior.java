package school.faang.BJS2_56484;

public class Warrior extends Character {
    private static final int WAR_POWER = 10;
    private static final int WAR_AGILITY = 5;
    private static final int WAR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WAR_POWER, WAR_AGILITY, WAR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.hasHealth()) {
            opponent.setHealth(opponent.getHealth() - getPower());
        } else {
            System.out.println("Противник " + opponent.getName() + " повержен!");
        }
    }

}
