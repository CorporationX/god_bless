package school.faang.bjs2_85639;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character opponent) {
        opponent.recieveDamage(getStrength());
    }
}
