package game;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s shoots at %s with agility %d%n", getName(), opponent.getName(), 10);
        opponent.takeDamage(10);
    }
}
