package school.faang.task_43822;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character c) {
        if (c.getHealth() > 0) {
            c.setHealth(c.getHealth() - getPower());
        } else {
            throw new IllegalArgumentException("The character you try to attack already dead :(");
        }
    }
}
