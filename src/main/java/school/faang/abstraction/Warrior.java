package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        int healthBeforeAttack = character.getHealth();
        character.setHealth(healthBeforeAttack - this.getPower());
    }
}
