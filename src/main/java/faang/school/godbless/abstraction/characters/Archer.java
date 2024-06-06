package faang.school.godbless.abstraction.characters;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    protected int getAttackPower() {
        return this.agility;
    }
}