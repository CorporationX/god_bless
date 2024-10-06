package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public Character attack(Character character) {
        character.health -= this.agility;
        return character;
    }
}
