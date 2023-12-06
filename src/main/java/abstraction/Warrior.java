package abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.dexterity = 5;
        this.intel = 3;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.power);
    }
}
