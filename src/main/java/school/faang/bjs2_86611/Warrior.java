package school.faang.bjs2_86611;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    @Override
    public int attack(Character opponent) {
        opponent.inAttack(this.getPower());
        return this.getHealth();
    }
}
