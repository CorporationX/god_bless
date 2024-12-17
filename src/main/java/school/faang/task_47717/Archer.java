package school.faang.task_47717;

public class Archer extends Unit {
    public Archer(int power) {
        super(power);
    }

    @Override
    public boolean isArcher() {
        return true;
    }
}
