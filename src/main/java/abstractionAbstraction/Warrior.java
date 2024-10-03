package abstractionAbstraction;

public class Warrior extends Character {
    public static final int WARRIOR_STRENGTH = 10;
    public static final int WARRIOR_AGILITY = 5;
    public static final int WARRIOR_INTELLIGENCE = 3;

    @Override
    public void attack(Character character) {
        character.decreaseHealth(WARRIOR_STRENGTH);
    }

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }
}
