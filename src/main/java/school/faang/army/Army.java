package school.faang.army;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class Army {
    private final List<Fighter> fighters = new ArrayList<>();

    public void addUnit(Fighter fighter) {
        fighters.add(fighter);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<ArmyRunnableCalculator> powersOfFighters = new ArrayList<>();

        for (Fighter fighter : fighters) {
            ArmyRunnableCalculator calculator = new ArmyRunnableCalculator(fighter);
            threads.add(new Thread(calculator));
            powersOfFighters.add(calculator);
        }

        for (Thread thread : threads) {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (ArmyRunnableCalculator calculator : powersOfFighters) {
            totalPower += calculator.getPower();
        }
        return totalPower;
    }

}

