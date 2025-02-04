package school.faang.sprint1.task_BJS2_56346;

public class Archer extends Character {
    public Archer(String name) {
        super(3, 10, 5);
        this.name = name;
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.agility);
    }
}
