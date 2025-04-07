package school.faang.bjs2_68093;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    void attack(Character opponent) {
        opponent.reduceHealth(this.strength);
    }
}
