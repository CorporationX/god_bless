package school.faang.Abstract;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealth(enemy.getHealth() - strength);
    }
}
