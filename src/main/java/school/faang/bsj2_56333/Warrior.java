package school.faang.bsj2_56333;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getStrength());
        if (opponent.reduceHealth()) {
            System.out.printf("The %s attacks the %s and deals %d damage.%n",
                    getName(), opponent.getName(), getStrength());
            System.out.printf("%s's health is %d health points.%n",
                    opponent.getName(), opponent.getHealth());
        } else {
            System.out.printf("%s is dead.%n", opponent.getName());
        }
    }
}
