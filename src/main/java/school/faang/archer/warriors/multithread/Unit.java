package school.faang.archer.warriors.multithread;

public abstract class Unit {
    protected int power;

    public Unit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
