package school.faang.task_43902;

public class Warrior extends Character {
    public static final int WARRIOR_STRENGTH = 10;
    public static final int WARRIOR_AGILITY = 5;
    public static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        int newHealth = enemy.getHealth() - strength;
        enemy.setHealth(newHealth);
    }
}