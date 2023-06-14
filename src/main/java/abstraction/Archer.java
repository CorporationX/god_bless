package abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int power, int dexterity, int intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.hp = character.hp - this.dexterity;
    }
}
