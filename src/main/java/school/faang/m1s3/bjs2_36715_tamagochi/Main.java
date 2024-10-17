package school.faang.m1s3.bjs2_36715_tamagochi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VladController vladController = new VladController();

        for (int i = 1; i < 12; i++) {
            vladController.addTamagotchi(new TamagotchiVlad("Vlad_" + i));
        }
        vladController.deleteTamagotchi("Vlad_11");

        ExecutorService service = Executors.newFixedThreadPool(vladController.getVlads().size());

        service.execute(() -> vladController.feedAll());
        service.execute(() -> vladController.sleepAll());
        service.execute(() -> vladController.playAll());
        service.execute(() -> vladController.cleanAll());

        service.shutdown();

        try {
            if (!service.awaitTermination(25, TimeUnit.SECONDS)) {
                System.out.println("Vlad's gone");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }

        System.out.println();
        System.out.println("Vlad is happy to say your code is great!");


    }
}
