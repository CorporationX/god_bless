package school.faang.distributed_armsey_hero_me_i_magia;

public class Swordsman extends Unit {
    private static final int INITIAL_POWER = 30;
    private static final int MAX_POWER = 1000;

    public Swordsman() {
        super(INITIAL_POWER);
    }

    public void setPower(int power) {
        super.setPower(Math.min(power, MAX_POWER));
    }
}
