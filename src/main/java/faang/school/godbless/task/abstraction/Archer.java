package faang.school.godbless.task.abstraction;

public class Archer extends Character {
    public static final int ARCHER_STRENGTH = 3;
    public static final int ARCHER_AGILITY = 10;
    public static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character enemy) {
        if (enemy.equals(this)) {
            System.out.println("Unfortunately You can't hit yourself");
        } else {
            enemy.getDamage(getAgility());
        }
    }

}
