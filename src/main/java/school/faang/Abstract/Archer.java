package school.faang.Abstract;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealth(enemy.getHealth() - agility);
    }
}
