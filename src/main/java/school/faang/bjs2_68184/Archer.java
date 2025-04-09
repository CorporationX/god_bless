package school.faang.bjs2_68184;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setAgility(10);
        this.setIntelligence(5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.getAgility());
    }
}