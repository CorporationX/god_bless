package abstraction;

public class Warrior extends Character {
    public static final int warriorStrength = 10;
    public static final int warriorAgility = 5;
    public static final int warriorIntelligence = 3;

    @Override
    public void attack(Character character) {
        character.decreaseHealth(this.strength);
    }

    public Warrior(String name) {
        super(name, warriorStrength, warriorAgility, warriorIntelligence);
    }
}
