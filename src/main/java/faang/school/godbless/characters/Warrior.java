package faang.school.godbless.characters;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name, 10,5,3,100);
    }

    @Override
    public Character attack(Character character) {
        character.health = character.health - this.strength;
        return character;
    }
}
