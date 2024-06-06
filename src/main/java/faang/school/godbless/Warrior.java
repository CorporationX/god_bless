package faang.school.godbless;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public void attack(Character enemy) {
        System.out.println(super.name + " attacks " + enemy.name);
        enemy.getInjured(super.force);
    }
}
