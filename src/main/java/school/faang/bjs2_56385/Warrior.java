package school.faang.bjs2_56385;

public class Warrior extends Character {
    public  Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s Warrior attack %d%n", getName(), getStrenght());
        reduceHealth(opponent, getStrenght());
    }
}
