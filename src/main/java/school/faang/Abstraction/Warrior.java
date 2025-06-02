package school.faang.Abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.setIntelligence(3);
        this.setStrength(10);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealPoint(opponent.getHealPoint() - getStrength());
    }

}
