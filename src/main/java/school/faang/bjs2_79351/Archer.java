package school.faang.bjs2_79351;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        setAgility(10);
        setIntellect(5);
        setStrength(3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth()-this.getAgility());
    }
}
