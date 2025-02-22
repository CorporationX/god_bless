package school.faang.bjs2_61300;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army{

    private final List<Squad> maps = new ArrayList<>();
    int sunsArmy =0;
    public void addSquad(Squad s)  {
        maps.add(s);
    }
    public int calculateTotalPower() {
        List<Thread> threadAmount = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        for (Squad squad : maps) {
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
