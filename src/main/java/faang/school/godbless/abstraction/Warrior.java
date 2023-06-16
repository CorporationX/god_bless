package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character unit) {
        float healthPoints = unit.health - force;
        unit.setHealth(healthPoints);
    }
}
