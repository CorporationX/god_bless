package school.faang.BJS2_56484;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int power, int agility, int intelligence) {
        super(name, 3, 10, 5);
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
