package school.faang.bjs2_85500;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntelligence(3);
    }

    @Override
    void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getStrength());
    }
}
