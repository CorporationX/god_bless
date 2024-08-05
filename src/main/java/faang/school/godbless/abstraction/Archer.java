package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setAgility(10);
        this.setIntellect(5);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHp(enemy.getHp() - this.getAgility());
    }
}
