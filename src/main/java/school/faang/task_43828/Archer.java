package school.faang.task_43828;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (getHealth() > 0) {
            opponent.takeDamage(getAgility());
        } else {
            System.out.println(getName() + " не может атаковать, так как мертв.");
        }
    }
}
