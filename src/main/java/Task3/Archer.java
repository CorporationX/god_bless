package Task3;

public class Archer extends Character{
    public Archer(String name) {
        super(name,3,10,5);
    }

    @Override
    public int attack(Character character) {
        return character.getHealth() - agility;
    }

}
