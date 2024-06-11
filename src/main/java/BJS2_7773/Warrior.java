package BJS2_7773;

public class Warrior extends Character {
    static final int FORCE = 10;
    static final int DEXTERITY = 5;
    static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, FORCE, DEXTERITY, INTELLIGENCE);
    }

    @Override
    void attack(Character character) {
        character.health -= force;
    }

}
