package school.faang.task_43902;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character damage) {
        damage.health -= strength;
    }
}