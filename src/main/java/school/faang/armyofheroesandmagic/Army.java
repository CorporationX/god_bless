package school.faang.armyofheroesandmagic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class Army {
    private final List<Squad> army = new ArrayList<>();

    public void addSquad(Squad squad) {
        army.add(squad);
    }

    public int calculateTotalPower() {
        List<FutureTask<Integer>> tasks = new ArrayList<>();
        for (Squad squad : army) {
            FutureTask<Integer> task = new FutureTask<>(squad::calculateSquadPower);
            Thread thread = new Thread(task);
            tasks.add(task);
            thread.start();
        }

        int totalPower = 0;
        for (FutureTask<Integer> task : tasks) {
            try {
                totalPower += task.get();
            } catch (InterruptedException e) {
                log.error("Поток прерван: {}", e.getMessage(), e);
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                log.error("Ошибка: {}", e.getMessage(), e);
            }
        }
        return totalPower;
    }

}
