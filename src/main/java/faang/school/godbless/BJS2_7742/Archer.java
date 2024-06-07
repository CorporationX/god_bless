package faang.school.godbless.BJS2_7742;

public class Archer extends Character {
    private final int strength;
    private final int agility;
    private final int intelligence;

    protected Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    protected void attack(Character enemy) {
        if (enemy.getHealth() >= agility)
            enemy.setHealth(enemy.getStrength() - agility);
    }
}
