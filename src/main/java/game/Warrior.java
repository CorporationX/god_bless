package game;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attacks %s with strength %d%n", getName(), opponent.getName(), 10);
        opponent.takeDamage(10);
    }
}
