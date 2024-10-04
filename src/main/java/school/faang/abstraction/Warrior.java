package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    protected void attack(Character character) {
        character.setHealth(character.getHealth()-this.getPower());
    }
}
