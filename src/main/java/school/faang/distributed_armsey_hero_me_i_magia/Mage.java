package school.faang.distributed_armsey_hero_me_i_magia;

public class Mage extends Unit {
    private static final int INITIAL_POWER = 40;
    private static final int MAX_POWER = 1000;

    public Mage() {
        super(INITIAL_POWER);
    }

    public void setPower(int power) {
        super.setPower(Math.min(power, MAX_POWER));
    }
}
