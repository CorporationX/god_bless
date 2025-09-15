package school.faang.bjs2_85639;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.recieveDamage(getAgility());
    }
}
