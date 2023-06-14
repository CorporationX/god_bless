package faang.school.godbless.task_3;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.Health = character.Health - this.power;
        System.out.println("character(warrior) health: " + character.Health);
    }
}
