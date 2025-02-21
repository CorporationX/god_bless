package school.faang.first_sprint.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attacks %s with %d damage \n", getName(), opponent.getName(), getAgility());
        dealDamage(opponent, getAgility());
    }
}
