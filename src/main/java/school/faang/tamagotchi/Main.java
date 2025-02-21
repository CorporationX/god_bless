package school.faang.tamagotchi;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int AWAIT_TERMINATION = 20;

    public static void main(String[] args) {

        TamagotchiVlad modelS = new TamagotchiVlad("ModelS");
        TamagotchiVlad modelE = new TamagotchiVlad("Model3");
        TamagotchiVlad modelX = new TamagotchiVlad("ModelX");

        VladController controller = new VladController();

        controller.addVlad(modelS);
        controller.addVlad(modelE);
        controller.addVlad(modelX);

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit(controller::playAll);
        executor.submit(controller::sleepAll);
        executor.submit(controller::cleanAll);
        executor.submit(controller::feedAll);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.warn("Потоки не завершили свою работу. Принудительное завершение");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван в процессе остановик ", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }
}
