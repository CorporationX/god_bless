package school.faang.task_47897;


import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();


    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<PowerCounter> unitPowers = new ArrayList<>();
        units.forEach(unit -> {
            PowerCounter powerCounter = new PowerCounter(unit);
            unitPowers.add(powerCounter);
            powerCounter.start();
        });

        for (PowerCounter powerCounter : unitPowers) {
            try {
                powerCounter.join();
                totalPower += powerCounter.getCurrentPower();
            } catch (InterruptedException e) {
                System.out.println("поток был прерван");
            }
        }
        return totalPower;
    }

}
