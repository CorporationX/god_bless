package faang.school.godbless.multithreading.heroes;

public class Mage extends Soldier {

    public Mage(int power) {
        super(power);
    }

    @Override
    public boolean isMage() {
        return true;
    }

    @Override
    public boolean isArcher() {
        return false;
    }

    @Override
    public boolean isSwordsman() {
        return false;
    }
}
