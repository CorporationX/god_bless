package faang.school.godbless.heroes_magic;

public abstract class Unit {
    private final int power;

    public Unit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

}
