package faang.school.godbless.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character enemy) {
        enemy.setHealth(enemy.getHealth() - getAgility());
    }
}
