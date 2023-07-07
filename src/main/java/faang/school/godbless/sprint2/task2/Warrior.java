package faang.school.godbless.sprint2.task2;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}