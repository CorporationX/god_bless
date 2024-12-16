package school.faang.task_43838.entity;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        int healthAfterDamage = target.getHealth() - this.getStrength();
        target.setHealth(healthAfterDamage);
    }
}
