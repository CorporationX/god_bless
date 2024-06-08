package faang.school.godbless.BJS2_7742;

public class Archer extends Character {
    protected Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    protected void attack(Character enemy) {
        if (enemy.getHealth() >= super.getAgility())
            enemy.setHealth(enemy.getStrength() - super.getAgility());
    }
}
