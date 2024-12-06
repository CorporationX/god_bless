package school.faang.BJS2_43903;

public class Archer extends Character {

    public Archer(String name) {
        super(name, Constants.ARCHER_POWER, Constants.ARCHER_AGILITY, Constants.ARCHER_INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(super.getHealth() - super.getAgility());
    }
}
