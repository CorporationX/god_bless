package school.faang.abstraction_abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 3, 5, 10);
    }

    @Override
    protected void attack(Character enemy) {
        enemy.setHp(enemy.getHp() - this.getStrength());
    }
}
