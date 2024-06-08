package faang.school.godbless.BJS2_7742;

public class Warrior extends Character {
    protected Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    protected void attack(Character enemy) {
        if (enemy.getHealth() >= super.getStrength())
            enemy.setHealth(enemy.getStrength() - super.getStrength());
    }
}
