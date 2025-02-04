package school.faang.bsj2_56333;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.reduceHealth()) {
            opponent.setHealth(opponent.getHealth() - getStrength());
            System.out.println("The " + getName() + " attacks the " + opponent.getName() +
                    " and deals " + getStrength() + " damage.");
            System.out.println(opponent.getName() + "'s health is " + opponent.getHealth() + " health points.");
        } else {
            System.out.println(opponent.getName() + " is dead.");
        }
    }
}
