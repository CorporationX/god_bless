package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name,
                GameProperties.STRENGTH_DEFAULT,
                GameProperties.AGILLITY_DEFAULT,
                GameProperties.INTELLIGENCE_DEFAULT);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }

}
