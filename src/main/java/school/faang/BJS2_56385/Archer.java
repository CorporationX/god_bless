package school.faang.BJS2_56385;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s Warrior attack %d%n", getName(), getStrenght());
        reduceStrength(opponent, getStrenght());
    }
}
