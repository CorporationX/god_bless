package school.faang.armyofheroes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Army {

    private static final int THREAD_NUMBER = 5;
    private static final int TIMEOUT = 5;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_NUMBER);
    private static final Logger LOGGER = LoggerFactory.getLogger(Army.class);

    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() {
        return squads.stream().map(squad -> {
            try {
                return EXECUTOR.submit(squad::calculateSquadPower).get();
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.error("Работа потока нарушена, возникла ошибка при добавлении отяада {}: {}",
                        squad, e.getMessage());
                Thread.currentThread().interrupt();
                return 0;
            }
        }).mapToInt(integer -> integer).sum();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                LOGGER.warn("Превышен тайм-аут. Принудительное завершение работы...");
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOGGER.error("Поток, прерванный во время завершения работы: {}", e.getMessage());
            EXECUTOR.shutdownNow();
            Thread.currentThread().interrupt();
        }
        LOGGER.info("Потоки успешно остановлены");
    }

}
