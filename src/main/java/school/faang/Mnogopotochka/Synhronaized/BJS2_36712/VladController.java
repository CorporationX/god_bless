package school.faang.Mnogopotochka.Synhronaized.BJS2_36712;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class VladController {
    private static final Logger log = LoggerFactory.getLogger(VladController.class);
    private static final int NUMBER_OF_THREADS = 5;
    private static final List<TamagotchiVlad> tamagotchiVladList = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        addTamagotchiVlad("Lexa");
        addTamagotchiVlad("Dima");
        addTamagotchiVlad("Miha");
        addTamagotchiVlad("Vika");
        addTamagotchiVlad("Biba");

        removeTamagotchiVlad("Biba");

        executorService.submit(VladController::feedAll);
        executorService.submit(VladController::playAll);
        executorService.submit(VladController::cleanAll);
        executorService.submit(VladController::sleepAll);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                log.error("Executor service did not terminate within the specified time.");
                throw new IllegalStateException("Executor service did not terminate within the specified time.");
            }
        } catch (InterruptedException e) {
            log.error("Executor service was interrupted", e);
            Thread.currentThread().interrupt();
        }

    }

    private static void feedAll() {
            tamagotchiVladList.forEach(TamagotchiVlad::feed);
    }

    private static void playAll() {
            tamagotchiVladList.forEach(TamagotchiVlad::play);
    }

    private static void cleanAll() {
            tamagotchiVladList.forEach(TamagotchiVlad::clean);
    }

    private static void sleepAll() {
            tamagotchiVladList.forEach(TamagotchiVlad::sleep);
    }

    private static void addTamagotchiVlad(String name) {
        validateName(name);
        tamagotchiVladList.add(new TamagotchiVlad(name));
        log.info("{} добавлен в список", name);
    }

    private static void removeTamagotchiVlad(String name) {
        validateName(name);
        tamagotchiVladList.removeIf(tamagochi -> tamagochi.getName().equals(name));
        log.info("{} удален из списка", name);
    }

    private static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            log.error("Iмя не может быть пустым");
            throw new IllegalArgumentException("Iмя не может быть пустым");
        }
    }
}
