package faang.school.godbless.army_of_heroes;

public class Mage extends Hero{
    public Mage(int power) {
        super(power);
    }

    @Override
    public boolean isMage() {
        return true;
    }
}
