package task_BJS2_61403;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class Army {
    private final List<Squad> squadsInArmy = new ArrayList<>();

    public void addSquad(@NonNull Squad squad) {
        squadsInArmy.add(squad);
    }

    public int calculateTotalPower() {
        List<Thread> threadAmount = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        for (Squad squad : squadsInArmy) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threadAmount.add(thread);
            thread.start();
        }
        for (Thread thread : threadAmount) {
            try {
                thread.join();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                log.info("Thread: {} was interrupted", Thread.currentThread().getName());
            }
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }
}
