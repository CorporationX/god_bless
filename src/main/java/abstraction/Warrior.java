package abstraction;

public class Warrior extends Character {

    public Warrior(String name, Integer power, Integer agility, Integer intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        Integer currentHealth = character.health - this.getPower();
        character.setHealth(currentHealth);
    }
}
