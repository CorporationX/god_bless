package school.faang.armyheroes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Army {
    List<Squad<? extends Heroes>> army;

    public Army() {
        army = new ArrayList<>();
    }

    public void addSquad(Squad<? extends Heroes> squad) {
        army.add(squad);
    }

    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newFixedThreadPool(army.size());
        List<Callable<Integer>> tasks = new ArrayList<>();

        for (Squad<? extends Heroes> squad : army) {
            tasks.add(squad::calculateSquadPower);
        }

        int total = 0;
        try {
            // invokeAll запускает все задачи,
            // переданные ему в виде списка, параллельно,
            // а возращает Future<Integer>
            List<Future<Integer>> result = executorService.invokeAll(tasks);

            for (Future<Integer> task : result) {
                total += task.get();
            }

        } catch (InterruptedException | ExecutionException exception) {
            exception.getMessage();
        } finally {
            executorService.shutdown();
        }
        return total;


    }

}
