package school.faang.sprint1.task_43502;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character characterToAttack) {
        characterToAttack.health -= agility;
    }
}
