package school.faang.models;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int strength, int agility, int intellect) {
        super(name, 3, 10, 5);
    }

    @Override
    public int attack(Character opponent) {
        int damage = this.getAgility();
        opponent.setHealth(opponent.getHealth() - damage);
        return damage;
    }
}
