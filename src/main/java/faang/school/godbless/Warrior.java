package faang.school.godbless;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    protected void attack(Character character) {
        if (character.health - this.strength >= 0)
            character.health -= this.strength;
        else
            character.health = 0;
    }
}