package school.faang.bjs2_86611;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    public Warrior(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    @Override
    public void attack(Character opponent) {
        opponent.inAttack(this.getPower());
    }
}
