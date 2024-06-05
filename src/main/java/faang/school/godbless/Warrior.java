package faang.school.godbless;

public class Warrior extends Character {
    private final int strength = 10;
    private final int agility = 5;
    private final int intelligence = 3;


    protected Warrior(String name) {
        super(name);
    }

    @Override
    protected void attack(Character enemy) {
        if (enemy.getHealth() >= strength)
            enemy.setHealth(enemy.getStrength() - strength);
    }
}
