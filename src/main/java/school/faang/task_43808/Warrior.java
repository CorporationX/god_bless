package school.faang.task_43808;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character player) {
        player.health -= this.power;
    }
}
