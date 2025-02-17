package bjs261069;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower(List<Squad> squads) {
        if (squads == null) {
            throw new IllegalArgumentException("Squads cannot be null");
        }
        List<Thread> threads = new ArrayList<>();
        for (Squad squad : squads) {
            PowerCalculator powerCalculator = new PowerCalculator();
            powerCalculator.setSquad(squad);
            Thread thread = new Thread(powerCalculator);
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread " + Thread.currentThread().getName() + "has interrupted", e);
            }
        });
        return PowerCalculator.powerSum.stream().mapToInt(Integer::intValue).sum();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
