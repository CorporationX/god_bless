package school.faang.task_43840;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intellect = 5;
    }

    @Override
    public void attack(Character character) {
        if (character != null) {
            int updatedHealth = Math.max(character.getHealth() - agility, 0);
            character.setHealth(updatedHealth);
        }
    }
}
