package faang.school.godbless.mightandmagic;

public class Swordsman extends Unit {
    public Swordsman(int power) {
        super(power);
    }

    @Override
    public boolean isSwordsman() {
        return true;
    }
}
