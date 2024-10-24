package school.faang.archer.warriors.multithread;

public class PowerCalculator extends Thread {
    private Unit unit;
    private int[] results;
    private int index;

    public PowerCalculator(Unit unit, int[] results, int index) {
        this.unit = unit;
        this.results = results;
        this.index = index;
    }

    @Override
    public void run() {
        results[index] = unit.getPower();
    }
}
