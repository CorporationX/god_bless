package faang.school.godbless.task3;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    protected void attack(Character character) {
        if (character.health - strength >= 0)
            character.health -= strength;
    }
}
