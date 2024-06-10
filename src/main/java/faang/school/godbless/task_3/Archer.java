package faang.school.godbless.task_3;

public class Archer extends Character {

    Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character character) {
        character.health -= this.agility;
    }
}
