package faang.school.godbless.mightandmagic;

public class Mage extends Unit {
    public Mage(int power) {
        super(power);
    }

    @Override
    public boolean isMage() {
        return true;
    }
}
