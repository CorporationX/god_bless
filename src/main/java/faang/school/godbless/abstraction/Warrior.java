package faang.school.godbless.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character enemy) {
        enemy.setHealth(enemy.getHealth() - getStrength());
    }
}
