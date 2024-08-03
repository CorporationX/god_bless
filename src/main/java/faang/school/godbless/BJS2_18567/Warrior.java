package faang.school.godbless.BJS2_18567;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        int damage = this.getPower();
        enemy.setHealth(enemy.getHealth() - damage);
    }
}

