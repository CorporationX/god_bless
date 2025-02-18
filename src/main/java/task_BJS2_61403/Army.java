package task_BJS2_61403;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {
    private final List<Squad> squadsInArmy = new ArrayList<>();

    public void addSquad(@NonNull Squad squad) {
        squadsInArmy.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threadAmount = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        for (Squad squad : squadsInArmy) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threadAmount.add(thread);
            thread.start();
        }
        for (Thread thread : threadAmount) {
            thread.join();
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }
}
