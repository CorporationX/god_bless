package abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int currentHealth = character.health - this.getPower();
        character.setHealth(currentHealth);
    }
}
