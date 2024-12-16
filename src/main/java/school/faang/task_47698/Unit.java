package school.faang.task_47698;

public abstract class Unit {
    protected int power;

    public Unit(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power cannot be negative");
        }
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
