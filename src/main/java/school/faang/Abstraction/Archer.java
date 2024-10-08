package school.faang.Abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getDexterity());
    }
}
