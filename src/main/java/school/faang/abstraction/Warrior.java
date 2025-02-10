package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 5, 5, 3);
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        int warriorStrength = getStrength();
        opponent.reduceHealth(warriorStrength);
    }
}
