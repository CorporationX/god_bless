package faang.school.godbless.model;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    protected void attack(Character character) {
        character.health -= strength;
    }
}
