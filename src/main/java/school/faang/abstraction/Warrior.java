package school.faang.abstraction;

public class Warrior extends school.faang.abstraction.Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.strength;
        opponent.applyDamage(damage);
    }
}
