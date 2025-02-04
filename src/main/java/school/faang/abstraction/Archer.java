package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    protected void attack(Character opponent) {
        if (opponent.getHealth() > 0) {
            opponent.updateHealth(this.getAgility());
        } else {
            System.out.println(opponent.getName() + " уже повержен");
        }
    }
}
