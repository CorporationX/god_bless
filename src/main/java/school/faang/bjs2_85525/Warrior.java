package school.faang.bjs2_85525;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character opponent) {
        int damage = getStrength();
        opponent.takeDamage(damage);
    }
}
