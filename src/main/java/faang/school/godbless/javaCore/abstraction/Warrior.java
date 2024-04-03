package faang.school.godbless.javaCore.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setDexterity(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHp(enemy.getHp() - this.getStrength());
    }
}
