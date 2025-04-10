package school.faang.abstraction_abstraction;


public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getStrength();
        validateHealthLevel(damage);
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
