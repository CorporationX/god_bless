package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name, GameProperties.ARCHER_STRENGTH, GameProperties.ARCHER_AGILITY, GameProperties.ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }

}
