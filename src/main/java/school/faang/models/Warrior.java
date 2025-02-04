package school.faang.models;

public class Warrior extends Character {

    public Warrior(String name, int strength, int agility, int intellect) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getStrength();
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
