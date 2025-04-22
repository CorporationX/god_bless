package school.faang.distributed_armsey_hero_me_i_magia;



public class Archer extends Unit {
    private static final int INITIAL_POWER = 50;
    private static final int MAX_POWER = 1000;

    public Archer() {
        super(INITIAL_POWER);
    }

    public void setPower(int power) {
        super.setPower(Math.min(power, MAX_POWER));
    }
}
