package school.faang;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intellect = 3;
    }
    @Override
    Character attack(Character character) {
        character.health -= this.power;
        return character;
    }
}
