package faang.school.godbless.sprint_1.task_43932;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        if (this.getHealth() <= 0) {
            return;
        }
        character.receiveDamage(this.getDexterity());
    }
}
