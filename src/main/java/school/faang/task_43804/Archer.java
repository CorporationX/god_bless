package school.faang.task_43804;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character character) {
        int characterHealth = character.getHealth() - this.getAgility();
        character.setHealth(characterHealth);
    }
}
