package school.faang.vladtamagochi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 4;
    private static final int START_FROM = 0;
    private static final int END_COUNT = 20;
    private static final int TIME_AWAIT_TERMINATION = 30;
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        VladController vladController = new VladController();

        for (int i = START_FROM; i < END_COUNT; i++) {
            vladController.addVlad(new TamagotchiVlad("Vladik " + i));
        }

        extracted(service, vladController);

        service.shutdown();
        try {
            if (!service.awaitTermination(TIME_AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                System.out.println("Владики разбежались!");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Interrupted while awaiting service termination.", e);
        }
    }

    private static void extracted(ExecutorService service, VladController vladController) {
        service.execute(vladController::feedAll);
        service.execute(vladController::playAll);
        service.execute(vladController::sleepAll);
        service.execute(vladController::cleanAll);
    }
}

