package school.faang.bsj43913;

public class Warior extends Character {
    public Warior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        enemy.heatPoints -= this.strength;
    }
}
