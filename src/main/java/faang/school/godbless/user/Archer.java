package faang.school.godbless.user;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(this.getAgility());
        System.out.println("Archer " + this.getName() + " attacks " + opponent.getName() + " for " + this.getAgility() + " damage.");
    }
}
