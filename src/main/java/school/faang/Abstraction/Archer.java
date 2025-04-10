package school.faang.Abstraction;

public class Archer extends Character {
    private static final int powerArcher = 3;
    private static final int dexterityArcher = 10;
    private static final int intellectArcher = 5;

    public Archer(String name) {
        super(name, powerArcher, dexterityArcher, intellectArcher);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHp(this.getDexterity());
    }
}
