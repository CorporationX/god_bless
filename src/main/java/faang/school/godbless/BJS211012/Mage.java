package faang.school.godbless.BJS211012;

public class Mage extends Character {
    public Mage(int power) {
        super(power, "Mage");
    }

    @Override
    public boolean isMage() {
        return true;
    }
}
