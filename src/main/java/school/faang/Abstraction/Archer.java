package school.faang.Abstraction;

public class Archer extends Character {


    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setAgility(10);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealPoint(opponent.getHealPoint() - getAgility());
    }


}
