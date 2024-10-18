package school.faang.task327;

import school.faang.task327.Vlad.TamagotchiVlad;
import school.faang.task327.Vlad.VladController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VladController vladController = new VladController();

        TamagotchiVlad firstVlad = new TamagotchiVlad("Vlad 1");
        TamagotchiVlad secondVlad = new TamagotchiVlad("Vlad 2");

        vladController.addVlad(firstVlad);
        vladController.addVlad(secondVlad);

        ExecutorService service = Executors.newFixedThreadPool(5);

        service.submit(firstVlad::sleep);
        service.submit(firstVlad::play);
        service.submit(() -> System.out.println(firstVlad.getName() + " " + firstVlad.getState()));

        service.submit(secondVlad::clean);
        service.submit(secondVlad::feed);
        service.submit(() -> System.out.println(secondVlad.getName() + " " + secondVlad.getState()));

        service.submit(() -> {
            vladController.sleepAll();
            System.out.println(firstVlad.getName() + " " + firstVlad.getState());
            System.out.println(secondVlad.getName() + " " + secondVlad.getState());
        });
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
