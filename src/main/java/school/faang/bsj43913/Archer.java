package school.faang.bsj43913;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10,5);
    }

    @Override
    public void attack(Character enemy) {
        enemy.heatPoints -= this.agility;
    }
}
