package school.faang.task_43934;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character c) {
        c.setHealth(c.health - dexterity);
    }
}
