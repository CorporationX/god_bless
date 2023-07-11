package faang.school.godbless.sword_and_magic;

public class Archer extends Unit {
    public Archer(int power) {
        super(power);
    }

    @Override
    public boolean isArcher() {
        return true;
    }
}
