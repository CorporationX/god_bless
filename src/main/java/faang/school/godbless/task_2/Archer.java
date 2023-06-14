package faang.school.godbless.task_2;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        if (character.isAlive(character)) {
            character.health -= strength;
            return;
        }
        System.out.println(character.name + " is already dead");
    }
}