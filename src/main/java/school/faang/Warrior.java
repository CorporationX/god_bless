package school.faang;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, GameProperties.WARRIOR_STRENGTH, GameProperties.WARRIOR_AGILITY, GameProperties.WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
    }

}
