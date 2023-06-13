package faang.school.godbless.task_2;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
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