package faang.school.godbless.abstraction;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character unit) {
        float healthPoints = unit.health - dexterity;
        unit.setHealth(healthPoints);
    }
}
