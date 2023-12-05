package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 3, 10, 5);

    }

    @Override
    void attack(Character character) {
        character.health = character.health - super.power;
    }
}
