package school.faang.sprint3.distributedarmy;

public class Mag extends Unit {
    public Mag(int power) {
        super(power);
    }

    @Override
    public boolean isMage() {
        return true;
    }
}
