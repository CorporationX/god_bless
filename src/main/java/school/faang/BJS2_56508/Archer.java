package school.faang.BJS2_56508;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.setHealth(opponent.getHealth() - getAgility());
        }
    }


}
