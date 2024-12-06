package school.faang.bjs243903;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, Constants.WARRIOR_POWER, Constants.WARRIOR_AGILITY, Constants.WARRIOR_INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(super.getHealth() - super.getPower());
    }
}
