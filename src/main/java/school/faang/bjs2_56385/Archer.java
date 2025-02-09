package school.faang.bjs2_56385;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s Alliance attack %d%n", getName(), getAgility());
        reduceHealth(opponent, getAgility());
    }
}
