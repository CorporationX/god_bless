package school.faang.task_43838.entity;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        target.setHealthAfterDamageTaken(target.getHealth() - this.getAgility());
    }
}
