package school.faang.parallelmm;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Army {
    private final List<Squad> squadList = new ArrayList<>();

    public void addSquad(Squad squad) {
        squadList.add(squad);
    }

    public int calculateTotalArmyPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> result = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : squadList) {
            Thread thread = new Thread(() -> result.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return result.stream().mapToInt(Integer::intValue).sum();
    }

}
