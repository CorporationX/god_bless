package AbstractionAbstraction;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }


    @Override
    public void attack(Character character) {
        character.setHealth(character.health - this.dexterity);
    }
}
