package faang.school.godbless.task_3;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.power;
        System.out.println("character(archer) health: " + character.health);
    }
}
