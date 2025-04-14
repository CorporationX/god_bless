package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getAgility();
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
