package faang.school.godbless.domain.task_heroes;

public abstract class Unit {
    private int power;

    public Unit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
