package school.faang.task_43804;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        int healthAfterDamage = character.getHealth() - this.getPower();
        character.setHealth(healthAfterDamage);
    }
}
