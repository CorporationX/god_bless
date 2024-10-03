package bjs2_31292;

public class Warrior extends Character {
    public static final Integer WARRIOR_POWER = 10;
    public static final Integer WARRIOR_AGILITY = 5;
    public static final Integer WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - getPower());
    }
}
