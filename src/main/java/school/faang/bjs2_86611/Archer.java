package school.faang.bjs2_86611;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    public Archer(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    @Override
    public void attack(Character opponent) {
        opponent.inAttack(this.getAgility());
    }
}
