package school.faang.bjs2_86611;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    public int attack(Character opponent) {
        opponent.inAttack(this.getAgility());
        return this.getHealth();
    }
}
