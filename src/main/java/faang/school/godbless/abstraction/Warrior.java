package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setAgility(5);
        this.setIntellect(3);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHp(enemy.getHp() - this.getStrength());
    }
}
