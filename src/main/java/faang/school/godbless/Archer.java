package faang.school.godbless;

public class Archer extends Character {
    private final int strength = 3;
    private final int agility = 10;
    private final int intelligence = 5;

    protected Archer(String name) {
        super(name);
    }

    @Override
    protected void attack(Character enemy) {
        if (enemy.getHealth() >= agility)
            enemy.setHealth(enemy.getStrength() - agility);
    }
}
