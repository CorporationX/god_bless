package school.faang;

public class Archer extends Character {
    public static final int DEFAULT_STRENGTH = 3;
    public static final int DEFAULT_DEXTERITY = 10;
    public static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);
        this.strength = DEFAULT_STRENGTH;
        this.dexterity = DEFAULT_DEXTERITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }
}
