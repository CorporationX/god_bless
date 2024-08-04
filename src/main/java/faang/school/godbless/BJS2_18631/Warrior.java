package faang.school.godbless.BJS2_18631;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int currentHealth = character.getHealth();
        character.setHealth(currentHealth - super.strength);
    }
}
