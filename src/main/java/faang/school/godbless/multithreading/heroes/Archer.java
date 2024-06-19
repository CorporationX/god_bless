package faang.school.godbless.multithreading.heroes;

public class Archer extends Soldier {

    public Archer(int power) {
        super(power);
    }

    @Override
    public boolean isMage() {
        return false;
    }

    @Override
    public boolean isArcher() {
        return true;
    }

    @Override
    public boolean isSwordsman() {
        return false;
    }
}
