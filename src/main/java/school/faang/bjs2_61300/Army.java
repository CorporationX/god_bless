package school.faang.bjs2_61300;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {

    private final List<Squad> units = new ArrayList<>();

    public void addSquad(Squad squad)  {
        units.add(squad);
    }

    public int calculateTotalPower() {
        List<Thread> threadAmount = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        for (Squad squad : units) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threadAmount.add(thread);
            thread.start();
        }
        for (Thread thread : threadAmount) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании потока", e);
                throw new RuntimeException("Ошибка при ожидании потока", e);
            }
        }
        return results.stream().mapToInt(Integer::intValue).sum();
    }
}
