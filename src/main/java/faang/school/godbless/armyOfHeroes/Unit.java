package faang.school.godbless.armyOfHeroes;

public abstract class Unit {
    protected int power;

    public Unit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}