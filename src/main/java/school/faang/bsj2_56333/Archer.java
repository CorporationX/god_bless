package school.faang.bsj2_56333;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.reduceHealth()) {
            opponent.setHealth(opponent.getHealth() - getAgility());
            System.out.println("The " + getName() + " attacks the " + opponent.getName() + " and deals " + getAgility() + " damage.");
            System.out.println(opponent.getName() + "'s health is " + opponent.getHealth() + " health points.");
        } else {
            System.out.println(opponent.getName() + " is dead.");
        }
    }
}
