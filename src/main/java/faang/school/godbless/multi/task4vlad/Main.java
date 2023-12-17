package faang.school.godbless.multi.task4vlad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VladController controller = new VladController();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        controller.addVlad(new TamagotchiVlad("Vlad1"));
        controller.addVlad(new TamagotchiVlad("Vlad2"));
        controller.addVlad(new TamagotchiVlad("Vlad3"));
        controller.removeVlad(new TamagotchiVlad("Vlad2"));

        Runnable task = () -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        };

        for (int i = 0; i < 3; i++) {
            executorService.execute(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
    }
}
