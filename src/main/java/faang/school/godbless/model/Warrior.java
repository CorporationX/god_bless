package faang.school.godbless.model;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    protected void attack(Character character) {
        if (character.health - strength >= 0)
            character.health -= strength;
    }
}
