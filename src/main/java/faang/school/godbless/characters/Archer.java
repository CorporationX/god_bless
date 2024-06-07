package faang.school.godbless.characters;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 3,10,5,100);
    }

    @Override
    public Character attack(Character character) {
        character.health = character.health - this.agility;
        return character;
    }
}
