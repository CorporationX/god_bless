package school.faang.abstractionabstraction;

public class Archer extends Character implements Attackable {

    public static final int DEFAULT_STRENGTH = 3;
    public static final int DEFAULT_DEXTERITY = 10;
    public static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.dexterity;
    }
}
