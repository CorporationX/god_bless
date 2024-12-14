package faang.school.godbless.week1;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        int damage = this.getAgility();
        target.setHealth(target.getHealth() - damage);
        System.out.println(this.getName() + " attacks " + target.getName() + " for " + damage + " damage. ");
    }
}
