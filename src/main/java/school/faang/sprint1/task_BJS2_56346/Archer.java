package school.faang.sprint1.task_BJS2_56346;

/**
 * Класс для тестов:
 * school/faang/sprint1/task_BJS2_56346/ArcherTest
 */

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
    }
}
