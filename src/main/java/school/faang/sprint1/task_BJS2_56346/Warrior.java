package school.faang.sprint1.task_BJS2_56346;

public class Warrior extends Character {
    public Warrior(String name) {
        super(10, 5, 3);
        this.name = name;
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.strength);
    }
}
