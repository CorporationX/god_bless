package school.faang;

public class Archer extends Character {
    public Archer(String name) {
        super(3, 10, 5, name);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getAgility();
        opponent.takeDamage(damage);
    }
}
