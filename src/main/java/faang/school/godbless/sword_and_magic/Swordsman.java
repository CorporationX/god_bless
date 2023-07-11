package faang.school.godbless.sword_and_magic;

public class Swordsman extends Unit {

    public Swordsman(int power) {
        super(power);
    }

    @Override
    public boolean isSwordsman() {
        return true;
    }
}
