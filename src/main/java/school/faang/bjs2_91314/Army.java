package school.faang.bjs2_91314;


import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class Army {

    private final List<Squad> army = new ArrayList<>();

    public  void addSquadToArmy(Squad squad) {
        army.add(squad);
    }

    public int calculateTotalPower() {
        final List<Thread> threads = new ArrayList<>();
        final List<Integer> squadsPower = new CopyOnWriteArrayList<>();
        for (Squad squad : army) {
            Thread thread = new Thread(() -> squadsPower.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Поток {} был прерван", thread.getName());
            }
        }
        return squadsPower.stream()
                .reduce(0, (Integer::sum));
    }
}
