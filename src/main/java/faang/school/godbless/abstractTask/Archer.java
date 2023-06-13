package faang.school.godbless.abstractTask;

public class Archer extends Character {
    public Archer(String name) {
        super(3, 10, 5, name);
    }


    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.getAgility());
        System.out.println("Target health" + target.getHealth());
    }

}
