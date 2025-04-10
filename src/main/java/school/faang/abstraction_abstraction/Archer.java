package school.faang.abstraction_abstraction;


public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getAgility();
        validateHealthLevel(damage);
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
