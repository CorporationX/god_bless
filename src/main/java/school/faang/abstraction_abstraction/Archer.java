package school.faang.abstraction_abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 5, 10, 3);
    }

    @Override
    protected void attack(Character enemy) {
        enemy.setHp(enemy.getHp() - this.getAgility());
    }
}
