package faang.school.godbless.parallelism.heroes_might_and_magic.entity;

public abstract class Unit {
    protected int power;

    public Unit(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
}
