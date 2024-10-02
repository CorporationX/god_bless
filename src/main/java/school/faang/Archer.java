package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    Character attack(Character character) {
        character.health -= this.agility;
        return character;
    }
}
