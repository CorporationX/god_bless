package school.faang.sprint3.squad;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;


public class Army {

    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public Long calculateTotalPower() {
        LongAdder totalPower = new LongAdder();
        List<Thread> threads = squads.stream()
                .map(squad -> {
                    Thread thread = new Thread(
                            () -> totalPower.add(squad.calculateTotalPower()));
                    thread.start();
                    return thread;
                })
                .toList();

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            return totalPower.sum();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ошибка ожидания посчета армии");
            return 0L;
        }
    }

}
