package school.faang.tamogachivlad.main;

import school.faang.tamogachivlad.maincode.TamagotchiVlad;
import school.faang.tamogachivlad.maincode.VladController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        VladController controller = new VladController();

        controller.addVlad(new TamagotchiVlad("vlad1"));
        controller.addVlad(new TamagotchiVlad("vlad2"));
        controller.addVlad(new TamagotchiVlad("vlad3"));
        controller.addVlad(new TamagotchiVlad("vlad4"));

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        service.submit(() -> controller.feedAll());
        service.submit(() -> controller.playAll());
        service.submit(() -> controller.cleanAll());
        service.submit(() -> controller.sleepAll());

        service.shutdown();
        try {
            if (!service.awaitTermination(2, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
