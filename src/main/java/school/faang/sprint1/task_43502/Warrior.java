package school.faang.sprint1.task_43502;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character characterToAttack) {
        characterToAttack.health -= strength;
    }
}
