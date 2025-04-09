package school.faang.bjs2_68184;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setAgility(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.getStrength());
    }
}