package school.faang.distributedarmy.maincode;


public class PowerCalculation implements Runnable {
    private Unit unit;
    private int power;

    public PowerCalculation(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = getPower();
    }

    public int getPower() {
        return unit.getPower();
    }
}
