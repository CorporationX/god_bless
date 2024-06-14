package faang.school.godbless.task3;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        int damage = this.power;
        target.health -= damage;
    }
}
