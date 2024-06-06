package faang.school.godbless;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public void attack(Character enemy) {
        System.out.println(super.name + " attacks " + enemy.name);
        enemy.getInjured(super.dexterity);
    }
}
