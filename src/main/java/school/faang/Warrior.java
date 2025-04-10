package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(10, 5, 3, name);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getStrength();
        opponent.takeDamage(damage);

    }
}
