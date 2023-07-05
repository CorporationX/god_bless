package faang.school.godbless.sprint3.heroes;


import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<CalculatePower> threads = new ArrayList<>();
        for (Unit unit : units) {
            CalculatePower thread = new CalculatePower(unit);
            thread.start();
            threads.add(thread);
        }
        for (CalculatePower thread : threads) {
            try {
                thread.join();
                totalPower += thread.getUnitPower();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower;
    }
}
