package faang.school.godbless.sprint_1.task_43932;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        if (this.getHealth() <= 0) {
            return;
        }
        character.receiveDamage(this.getStrength());
    }

}
