package faang.school.godbless.task_3;

public class Warrior extends Character {

    Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        character.health -= this.strength;
    }
}
