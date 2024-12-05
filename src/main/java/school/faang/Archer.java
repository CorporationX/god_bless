package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name, GameProperties.ArcherStrength, GameProperties.ArcherAgility, GameProperties.ArcherIntelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }

}
