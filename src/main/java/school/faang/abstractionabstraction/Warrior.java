package school.faang.abstractionabstraction;

public class Warrior extends Character implements Attackable {

    public static final int DEFAULT_STRENGTH = 10;
    public static final int DEFAULT_DEXTERITY = 5;
    public static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
