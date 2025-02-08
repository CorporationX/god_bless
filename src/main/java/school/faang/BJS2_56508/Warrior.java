package school.faang.BJS2_56508;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    protected void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.setHealth(opponent.getHealth() - getStrength());
        }
    }
}
