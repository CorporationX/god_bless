package school.faang.heroes;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {

    private List<Warrior> armyList = new ArrayList<>();

    public void addUnit(Warrior warrior) {
        armyList.add(warrior);
    }

    public int calculateTotalPower() {

        List<PowerCalculator> threads = new ArrayList<>();
        for (int i = 0; i < armyList.size(); i++) {
            PowerCalculator calculator = new PowerCalculator(armyList.subList(i, i + 1));
            threads.add(calculator);
            calculator.start();
        }

        int totalPower = 0;
        for (PowerCalculator calc : threads) {
            try {
                calc.join();
                totalPower += calc.getResult();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("The thread was interrupted while computing power", e);
            }
        }
        return totalPower;
    }


}
