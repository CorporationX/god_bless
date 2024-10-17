package school.faang.vladtamagochi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        VladController vladController = new VladController();

        for (int i = 0; i < 20; i++) {
            vladController.addVlad(new TamagotchiVlad("Vladik " + i));
        }

        service.execute(vladController::feedAll);
        service.execute(vladController::playAll);
        service.execute(vladController::sleepAll);
        service.execute(vladController::cleanAll);

        service.shutdown();
        try {
            if (!service.awaitTermination(8, TimeUnit.SECONDS)) {
                System.out.println("Владики разбежались!");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

