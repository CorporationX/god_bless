package school.faang;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s Archer attack %d%n", getName(), getAgility());
        reduceStrength(opponent, getAgility());
    }
}