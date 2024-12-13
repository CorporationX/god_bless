package school.faang.task_43934;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character c) {
        c.setHealth(c.health - power);
    }
}
