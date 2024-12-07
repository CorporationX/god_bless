package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        int healthAfterAttack = character.getHealth() - this.getAgility();
        character.setHealth(healthAfterAttack);
    }
}
