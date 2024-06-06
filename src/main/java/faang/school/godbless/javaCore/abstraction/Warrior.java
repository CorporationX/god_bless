package faang.school.godbless.javaCore.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        power = 10;
        dexterity = 5;
        intellect = 3;
    }

    @Override
    public Character attack(Character character) {
        character.health -= this.power;
        return character;
    }
}