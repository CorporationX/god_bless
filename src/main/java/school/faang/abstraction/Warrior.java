package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setStrength(5);
        setAgility(5);
        setIntelligence(3);
    }

    @Override
    void attack(Character opponent) {
        int opponentsHealth = opponent.getHealth();
        int warriorStrength = getStrength();
        opponent.setHealth(opponentsHealth - warriorStrength);
    }
}
