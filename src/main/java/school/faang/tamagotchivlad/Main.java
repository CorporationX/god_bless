package school.faang.tamagotchivlad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Vlad1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Vlad2");
        TamagotchiVlad vlad3 = new TamagotchiVlad("Vlad3");

        controller.addTamagotchi(vlad1);
        controller.addTamagotchi(vlad2);
        controller.addTamagotchi(vlad3);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(controller::feedAll);
        executorService.submit(controller::playAll);
        executorService.submit(controller::cleanAll);
        executorService.submit(controller::sleepAll);

        executorService.shutdown();
    }
}
