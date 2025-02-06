package school.faang.BJS2_58634;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
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