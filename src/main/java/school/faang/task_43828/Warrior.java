package school.faang.task_43828;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 100, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (getHealth() > 0) {
            opponent.takeDamage(getStrength());
        } else {
            System.out.println(getName() + " не может атаковать, так как мертв.");
        }
    }
}
