package school.faang.task_47975;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = units.stream()
                .map(unit -> executorService.submit(unit::getPower))
                .toList();
        int totalPower = 0;
        for (Future<Integer> future : futures) {
            totalPower += future.get();
        }
        executorService.shutdown();

        return totalPower;
    }
}
