package school.faang.BJS2_58634;

public class Warrior extends Character {

    private static final int STRENGTH = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        while (opponent.getHp() > 0) {
            setHp(opponent.getHp() - opponent.getStrength());
            if (opponent.getHp() > 0) {
                System.out.println("Враг " + opponent.getName() + " повержен!");
                break;
            }
        }
    }
}