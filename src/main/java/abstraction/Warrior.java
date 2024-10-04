package abstraction;

public class Warrior extends Character {
    public static int warriorStrength = 10;
    public static int warriorAgility = 5;
    public static int warriorIntelligence = 3;

    @Override
    public void attack(Character character) {
        character.decreaseHealth(warriorStrength);
    }

    public Warrior(String name) {
        super(name, warriorStrength, warriorAgility, warriorIntelligence);
    }
}
