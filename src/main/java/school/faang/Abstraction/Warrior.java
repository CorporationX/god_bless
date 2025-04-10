package school.faang.Abstraction;

public class Warrior extends Character {

    private static final int powerWarrior = 3;
    private static final int dexterityWarrior = 10;
    private static final int intellectWarrior = 5;

    public Warrior(String name) {
        super(name, powerWarrior, dexterityWarrior, intellectWarrior);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHp(this.getPower());
    }
}
