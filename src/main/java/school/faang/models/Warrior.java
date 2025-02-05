package school.faang.models;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public int attack(Character opponent) {
        int damage = this.getStrength();
        opponent.setHealth(opponent.getHealth() - damage);
        return opponent.getHealth();
    }
}
