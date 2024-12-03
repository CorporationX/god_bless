package school.faang.task_43822;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setPower(3);
        setStamina(10);
        setIq(5);
    }

    @Override
    public void attack(Character c) {
        if (c.getHealth() < 0) {
            throw new IllegalArgumentException("The character you try to attack already dead :(");
        } else {
            c.setHealth(c.getHealth() - getStamina());
        }
    }
}
