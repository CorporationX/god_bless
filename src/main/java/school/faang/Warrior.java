package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s Warrior attack %d%n", getName(), getStrength());
        reduceStrength(opponent, getStrength());
    }
}