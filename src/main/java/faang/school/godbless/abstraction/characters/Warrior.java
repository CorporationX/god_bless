package faang.school.godbless.abstraction.characters;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    @Override
    protected int getAttackPower() {
        return this.strength;
    }
}
