package abstraction;

public class Archer extends Character {

    public Archer(String name, int power, int agility, int intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int currentHealth = character.health - this.getPower();
        character.setHealth(currentHealth);
    }
}
