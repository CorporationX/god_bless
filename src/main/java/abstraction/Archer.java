package abstraction;

public class Archer extends Character {

    public Archer(String name, Integer power, Integer agility, Integer intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        Integer currentHealth = character.health - this.getPower();
        character.setHealth(currentHealth);
    }
}
