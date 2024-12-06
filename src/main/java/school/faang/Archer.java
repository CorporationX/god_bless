package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name,
                GameProperties.Strength_Default,
                GameProperties.Agility_Default,
                GameProperties.Intelligence_Default);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }

}
