package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        super.setAgility(10);
        super.setStrength(3);
        super.setIntelligence(5);
    }

    @Override
    void attack(Character opponent) {
        opponent.HP -= getAgility();
    }
}
