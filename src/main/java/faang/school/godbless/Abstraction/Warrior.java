package faang.school.godbless.Abstraction;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public void attack(Character enemy) {
        System.out.println(this.name + " attacks " + enemy.name);
        enemy.getInjured(this.force);
    }
}
