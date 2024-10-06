package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public Character attack(Character character) {
        character.health -= this.strength;
        return character;
    }
}
