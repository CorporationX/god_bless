package school.faang.AbstractionAbstraction;

public class Warrior extends Character {
    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getStrength();
        opponent.takeDamage(damage);
    }
}
