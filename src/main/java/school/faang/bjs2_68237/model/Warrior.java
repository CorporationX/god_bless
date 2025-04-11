package school.faang.bjs2_68237.model;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= opponent.strength;
        opponent.checkHealth();
    }
}