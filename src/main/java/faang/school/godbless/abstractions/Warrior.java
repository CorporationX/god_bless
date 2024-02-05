package faang.school.godbless.abstractions;

public class Warrior extends Character {

    Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
