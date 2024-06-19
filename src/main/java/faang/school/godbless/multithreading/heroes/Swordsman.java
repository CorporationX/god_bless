package faang.school.godbless.multithreading.heroes;

public class Swordsman extends Soldier {

    public Swordsman(int power) {
        super(power);
    }

    @Override
    public boolean isMage() {
        return false;
    }

    @Override
    public boolean isArcher() {
        return false;
    }

    @Override
    public boolean isSwordsman() {
        return true;
    }
}
