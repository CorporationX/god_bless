package faang.school.godbless.model;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        enemy.health -= this.agility;
    }
}
