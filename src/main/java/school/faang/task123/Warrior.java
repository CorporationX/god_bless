package school.faang.task123;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int newHealth = character.getHealth() - this.getStrength();
        character.setHealth(newHealth);
    }

}
