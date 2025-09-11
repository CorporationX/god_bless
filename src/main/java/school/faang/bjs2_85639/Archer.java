package school.faang.bjs2_85639;

public class Archer extends Character {
    Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character opponent) {
        opponent.recieveDamage(getAgility());
    }
}
