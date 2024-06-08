package BJS2_7773;

public class Archer extends Character {
    public Archer(String name) {
        super(name,3, 10, 5);
    }

    @Override
    void attack(Character character) {
        character.health -= dexterity;
    }

}
