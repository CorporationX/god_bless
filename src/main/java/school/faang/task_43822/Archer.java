package school.faang.task_43822;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character c) {
        if (c.getHealth() > 0) {
            c.setHealth(c.getHealth() - getStamina());
        } else {
            throw new IllegalArgumentException("The character you try to attack already dead :(");
        }
    }
}
