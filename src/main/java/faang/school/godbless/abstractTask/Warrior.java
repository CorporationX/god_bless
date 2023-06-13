package faang.school.godbless.abstractTask;

public class Warrior extends Character {
    public Warrior(String name) {
        super(10, 5, 3, name);
    }


    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.getStrength());
        System.out.println("Target health" + target.getHealth());
    }
}
