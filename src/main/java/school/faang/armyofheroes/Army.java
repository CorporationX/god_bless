package school.faang.armyofheroes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {

    private static final int THREAD_NUMBER = 5;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_NUMBER);
    private static final Logger LOGGER = LoggerFactory.getLogger(Army.class);

    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() {
        int totalPower = squads.stream().map(squad -> {
            try {
                return EXECUTOR.submit(squad::calculateSquadPower).get();
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.error("Threads are not working at calculateTotalPower");
                return 0;
            }
        }).mapToInt(integer -> integer).sum();
        EXECUTOR.shutdown();
        return totalPower;
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
