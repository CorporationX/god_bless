package faang.school.godbless.homm;

public class Archer extends Unit {

    public Archer(int power) {
        super(power);
    }

    @Override
    public boolean isArcher() {
        return true;
    }
}
