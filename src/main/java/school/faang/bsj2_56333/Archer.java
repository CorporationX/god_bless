package school.faang.bsj2_56333;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getAgility());
        if (opponent.isAlive()) {
            System.out.printf("The %s attacks the %s and deals %d damage.%n",
                    getName(), opponent.getName(), getAgility());
            System.out.printf("%s's health is %d health points.%n",
                    opponent.getName(), opponent.getHealth());
        } else {
            System.out.printf("The %s attacks the %s and deals %d damage.%n",
                    getName(), opponent.getName(), getAgility());
            System.out.printf("%s is dead.%n", opponent.getName());
        }
    }
}
