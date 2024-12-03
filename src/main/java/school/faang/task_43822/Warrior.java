package school.faang.task_43822;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setPower(10);
        setStamina(5);
        setIq(3);
    }

    @Override
    public void attack(Character c) {
        if (c.getHealth() < 0) {
            throw new IllegalArgumentException("The character you try to attack already dead :(");
        } else {
            c.setHealth(c.getHealth() - getPower());
        }
    }
}
