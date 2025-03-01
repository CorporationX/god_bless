package school.faang.task_BJS2_61262;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Army {
    private List<Squad<?>> army;
    public static final int timeout_minutes = 1;

    public int calculateTotalPower() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(army.size());
        List<Future<Integer>> listOfEachSquadPower = new ArrayList<>();
        for (Squad squad : army) {
            listOfEachSquadPower.add(executorService.submit(() -> squad.calculateSquadPower()));
        }
        int totalPower = 0;
        for (Future<Integer> future : listOfEachSquadPower) {
            totalPower += future.get();
        }
        executorService.shutdown();
        executorService.awaitTermination(timeout_minutes, TimeUnit.MINUTES);
        return totalPower;
    }
}
