package school.faang.abstraction;

public class Archer extends school.faang.abstraction.Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.agility;
        opponent.applyDamage(damage);
    }
}
