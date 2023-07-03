package tamagotchi_vlad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Vlad1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Vlad2");
        TamagotchiVlad vlad3 = new TamagotchiVlad("Vlad3");
        TamagotchiVlad vlad4 = new TamagotchiVlad("Vlad4");

        controller.addVlad(vlad1);
        controller.addVlad(vlad2);
        controller.addVlad(vlad3);
        controller.addVlad(vlad4);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            TamagotchiVlad vlad5 = new TamagotchiVlad("Vlad5");
            controller.addVlad(vlad5);
            controller.removeVlad(vlad1);
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });
        executorService.submit(() -> {
            controller.removeVlad(vlad1);
            controller.wakeUpAll();
            controller.feedAll();
            controller.playAll();
            controller.sleepAll();
            controller.sleepAll();
        });
        executorService.shutdown();

    }
}
