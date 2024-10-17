package Army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Warrior> army = new ArrayList<>();

    public void addWarrior(Warrior warrior) {
        army.add(warrior);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<PowerCalculator> threads = new ArrayList<>();
        for (Warrior warrior : army) {
            PowerCalculator calculator = new PowerCalculator(warrior);
            threads.add(calculator);
            calculator.start();
        }
        for (PowerCalculator thread : threads) {
            try {
                thread.join();
                totalPower += thread.getResult();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower;
    }
}
