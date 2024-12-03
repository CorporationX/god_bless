package school.faang.sprint_1.task_bjs243837;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int healthAfterAttack = opponent.getHealth() - this.getAgility();
        opponent.setHealth(healthAfterAttack);
    }
}
