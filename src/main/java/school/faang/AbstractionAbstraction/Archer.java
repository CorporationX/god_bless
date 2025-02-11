package school.faang.AbstractionAbstraction;

public class Archer extends Character {
    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getAgility();
        opponent.takeDamage(damage);
    }
}
