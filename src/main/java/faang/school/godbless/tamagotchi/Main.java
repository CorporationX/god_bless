package faang.school.godbless.tamagotchi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TamagotchiVlad tamagotchi1 = new TamagotchiVlad("Влад");
        TamagotchiVlad tamagotchi2 = new TamagotchiVlad("Сергей");

        VladController controller = new VladController();
        controller.addTamagochi(tamagotchi1);
        controller.addTamagochi(tamagotchi2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                controller.sleepAll();
                controller.playAll();
                controller.feedAll();
                controller.cleanAll();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        executorService.submit(() -> {
            try {
                controller.sleepAll();
                controller.playAll();
                controller.removeTamagochi(tamagotchi1);
                controller.feedAll();
                controller.cleanAll();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        executorService.shutdown();
    }
}
