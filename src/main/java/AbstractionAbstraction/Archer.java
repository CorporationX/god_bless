package AbstractionAbstraction;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        setStrength(3);
        setDexterity(10);
        setIntelligence(5);
    }

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getDexterity());
    }
}
