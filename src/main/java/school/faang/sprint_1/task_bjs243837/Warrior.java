package school.faang.sprint_1.task_bjs243837;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int healthAfterAttack = opponent.getHealth() - this.getStrength();
        opponent.setHealth(healthAfterAttack);
    }
}
