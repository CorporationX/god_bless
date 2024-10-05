package abstraction;

public class Archer extends Character {
    public static final int archerStrength = 3;
    public static final int archerIntelligence = 5;
    public static final int archerAgility = 10;

    @Override
    public void attack(Character character) {
        character.decreaseHealth(this.agility);
    }

    public Archer(String name) {
        super(name, archerStrength, archerAgility, archerIntelligence);
    }
}
