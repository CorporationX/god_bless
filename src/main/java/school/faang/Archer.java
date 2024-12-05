package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name, GameProperties.Archer_Strength, GameProperties.Archer_Agility, GameProperties.Archer_Intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }

}
