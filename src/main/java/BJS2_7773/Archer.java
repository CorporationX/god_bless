package BJS2_7773;

public class Archer extends Character {
    static final int FORCE = 3;
    static final int DEXTERITY = 10;
    static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, FORCE, DEXTERITY, INTELLIGENCE);
    }

    @Override
    void attack(Character character) {
        character.health -= dexterity;
    }

}
