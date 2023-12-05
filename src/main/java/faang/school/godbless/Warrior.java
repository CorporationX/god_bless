package faang.school.godbless;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        character.health = character.health - this.power;
    }
}
