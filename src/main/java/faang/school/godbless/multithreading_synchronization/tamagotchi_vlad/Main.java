package faang.school.godbless.multithreading_synchronization.tamagotchi_vlad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VladController vladController = new VladController();
        TamagotchiVlad tamagotchiVlad1 = new TamagotchiVlad("1");
        TamagotchiVlad tamagotchiVlad2 = new TamagotchiVlad("2");

        vladController.addTamagotchi(tamagotchiVlad1);
        vladController.addTamagotchi(tamagotchiVlad2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() ->{
            vladController.feedAll();
            vladController.playAll();
            vladController.cleanAll();
            vladController.sleepAll();
        });
        executorService.execute(() ->{
            vladController.cleanAll();
            vladController.sleepAll();
            vladController.feedAll();
            vladController.playAll();
        });
    }
}
