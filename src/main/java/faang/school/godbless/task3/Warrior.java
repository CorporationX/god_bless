package faang.school.godbless.task3;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character target) {
        int damage = power;
        target.health -= damage;
    }
}
