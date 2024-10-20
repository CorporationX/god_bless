package module_3.module_3_2_Synchronized_wait_notify.tamagotchiVlad_36717;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final int COUNT_VLADS = 5;
    private static final int START = 0;

    public static void main(String[] args) {
        VladController vladController = new VladController();

        for (int i = START; i < COUNT_VLADS; i++) {
            TamagochiVlad tamagochiVlad = new TamagochiVlad("Влад " + i);
            vladController.addVlad(tamagochiVlad);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        actionForVlad(executorService, vladController);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(50, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOG.warn("Thread interrupted {}", e.getMessage());
        }
        LOG.info("Программа завершеет свою работу...");
    }

    public static void actionForVlad(ExecutorService executorService, VladController vladController) {
        executorService.submit(vladController::feedAll);
        executorService.submit(vladController::cleanAll);
        executorService.submit(vladController::sleepAll);
        executorService.submit(vladController::playAll);
    }
}
