package school.faang.parallelism.homm_army_distributor;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army {
    private final List<Squad> army = new ArrayList<>();
    private final AtomicInteger totalPower = new AtomicInteger(0);

    public void addSquad(Squad squad) {
        army.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        totalPower.set(0);
        int threadAmount = army.size();

        List<Thread> threadPool = new ArrayList<>(threadAmount);

        for (Squad squad : army) {
            Thread thread = new Thread(() -> {
                int squadPower = squad.calculateSquadPower();
                totalPower.addAndGet(squadPower);
            });
            threadPool.add(thread);
            thread.start();
        }

        for (Thread thread : threadPool) {
            thread.join();
        }

        return totalPower.get();
    }
}
