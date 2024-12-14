package school.faang.task123;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int newHealth = character.getHealth() - this.getAgility();
        character.setHealth(newHealth);
    }

}
