package school.faang.BJS2_58634;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        while (opponent.getHp() > 0) {
            setHp(opponent.getHp() - opponent.getAgility());
            if (opponent.getHp() > 0) {
                System.out.println("Враг " + opponent.getName() + " повержен!");
                break;
            }
        }
    }
}
