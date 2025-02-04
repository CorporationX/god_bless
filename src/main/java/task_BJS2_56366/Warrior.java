package task_BJS2_56366;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = getStrength();
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
