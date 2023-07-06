package tamagochi_vlad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VladController controller = new VladController();

        TamagotchiVlad tamagotchi1 = new TamagotchiVlad("Vlad 1");
        TamagotchiVlad tamagotchi2 = new TamagotchiVlad("Vlad 2");

        controller.addTamagotchi(tamagotchi1);
        controller.addTamagotchi(tamagotchi2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        runControllerTasks(controller, executorService);
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);

        controller.removeTamagotchi(tamagotchi1);

        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        runControllerTasks(controller, executorService2);
        executorService2.shutdown();
        executorService2.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
    }

    private static void runControllerTasks(VladController controller, ExecutorService executorService) {
        executorService.submit(() -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });
    }
}
