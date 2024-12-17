package school.faang.bjs247633;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private final List<Fighter> fighters = new ArrayList<>();
    TheadForCalculation thread;

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public int calculateTotalPower() {
        int sumOfPower = 0;
        List<TheadForCalculation> threads = new ArrayList<>();

        for (Fighter fighter : fighters) {
            thread = new TheadForCalculation(fighter);
            threads.add(thread);
            thread.start();
        }

        for (TheadForCalculation thead : threads) {
            try {
                thead.join();
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        }

        for (TheadForCalculation thead : threads) {
            sumOfPower += thead.getPower();
        }
        return sumOfPower;
    }
}