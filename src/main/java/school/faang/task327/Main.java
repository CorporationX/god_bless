package school.faang.task327;

import school.faang.task327.Vlad.TamagotchiVlad;
import school.faang.task327.Vlad.VladController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VladController vladController = new VladController();

        for (int i = 0; i < 25; i++) {
            vladController.addVlad(new TamagotchiVlad("vlad" + i));
        }

        ExecutorService service = Executors.newFixedThreadPool(5);

        service.execute(vladController::sleepAll);
        service.execute(vladController::cleanAll);
        service.execute(vladController::feedAll);
        service.execute(vladController::cleanAll);

        service.shutdown();

        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ошибка, влады умерли");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
