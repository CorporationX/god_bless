package faang.school.godbless.multithreading.army;

public class Archer extends Hero {
    public Archer(Integer power) {
        super(power);
    }

    @Override
    public boolean isArcher() {
        return true;
    }
}
