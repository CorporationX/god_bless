package faang.school.godbless.sword_and_magic;

public class Mage extends Unit {

    public Mage(int power) {
        super(power);
    }

    @Override
    public boolean isMage() {
        return true;
    }
}
