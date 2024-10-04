package abstraction;

public class Archer extends Character {
    public static int archerStrength = 3;
    public static int archerIntelligence = 5;
    public static int archerAgility = 10;

    @Override
    public void attack(Character character) {
        character.decreaseHealth(archerAgility);
    }

    public Archer(String name) {
        super(name, archerStrength, archerAgility, archerIntelligence);
    }
}
