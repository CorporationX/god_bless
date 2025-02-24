package HeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<PowerCalculatorThread> threads = squads.stream()
                .map(squad -> {
                    PowerCalculatorThread thread = new PowerCalculatorThread(squad);
                    thread.start();
                    return thread;
                })
                .toList();

        List<Integer> results = threads.stream()
                .map(thread -> {
                    try {
                        thread.join();
                        return thread.getResult();
                    } catch (InterruptedException e) {
                        System.out.println("Поток был прерван: " + e.getMessage());
                        return 0;
                    }
                })
                .toList();

        return results.stream().mapToInt(Integer::intValue).sum();
    }
}
