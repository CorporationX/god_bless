package school.faang.abstraction_abstraction;


public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getAgility();
        validateHealthLevel(opponent);
        opponent.receiveDamage(damage);
    }

    @Override
    public void receiveDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
    }
}
