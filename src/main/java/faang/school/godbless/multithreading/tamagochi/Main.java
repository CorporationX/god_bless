package faang.school.godbless.multithreading.tamagochi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int NUM_THREADS = 4;
    public static void main(String[] args) throws InterruptedException {
        TamagochiController controller = new TamagochiController(new ArrayList<>(List.of(
                new TamagochiVlad("Кошка"),
                new TamagochiVlad("Собака")
        )));

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        executor.execute(() -> controller.feedAll("Яблоко"));
        Thread.sleep(100);
        executor.execute(() -> controller.playAll("Мячик"));
        Thread.sleep(100);
        executor.execute(() -> controller.addTamagochi(new TamagochiVlad("Енот")));
        Thread.sleep(100);
        executor.execute(controller::cleanAll);
        Thread.sleep(100);
        executor.execute(() -> controller.removeTamagochi(new TamagochiVlad("Собака")));
        Thread.sleep(100);
        executor.execute(controller::sleepAll);

        executor.shutdown();
        boolean isTerminated;
        try {
            isTerminated = executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Потоки завершились: " + isTerminated);
    }
}
