package school.faang.a_distributed_army_of_sword_and_magic_heroes.BJS2_61166;

import lombok.Getter;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army {
    private static final Logger LOGGER = LoggerFactory.getLogger(Army.class);

    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    private final AtomicInteger totalPower = new AtomicInteger();
    private final List<Squad> army = new CopyOnWriteArrayList<>();
    private CountDownLatch latch;

    public void addSquad(@NonNull Squad squad) {
        army.add(squad);
        LOGGER.info("Added squad: {}", squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        latch = new CountDownLatch(army.size());
        List<Squad> squads = new ArrayList<>(army);
        for (Squad squad : squads) {
            executor.submit(() -> {
                try {
                    int squadPower = squad.calculateSquadPower();
                    totalPower.addAndGet(squadPower);
                } catch (Exception e) {
                    throw new RuntimeException("Squad strength calculation error", e);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        executor.shutdown();
        System.out.println("All tasks are complete.");

        LOGGER.info("Calculation of the army's strength has been made");

        return totalPower.get();
    }
}
