package faang.school.godbless.Army_Sorted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@AllArgsConstructor
@Getter
@Setter
public class Army {
    private List<Warrior> divisions;

    public void calculateTotalPower(Army army) throws ExecutionException {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(divisions.size());
            List<Future<Integer>> futures = new ArrayList<>();

            for (Warrior warrior : army.getDivisions()) {
                Callable<Integer> task = () -> warrior.getPower();
                Future<Integer> future = executor.submit(task);
                futures.add(future);
            }
            int totalPower = 0;
            for (Future<Integer> future : futures) {
                totalPower += future.get();
            }
            System.out.println("Сила армии: " + totalPower);
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
