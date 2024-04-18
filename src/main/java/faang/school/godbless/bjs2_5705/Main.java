package faang.school.godbless.bjs2_5705;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        VladController vladController = new VladController();

        TamagotchiVlad programmer = new TamagotchiVlad("Programmer");
        TamagotchiVlad businessman = new TamagotchiVlad("Businessman");
        List<TamagotchiVlad> tamagochies = new ArrayList<>();

        tamagochies.add(programmer);
        tamagochies.add(businessman);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (TamagotchiVlad vlad : tamagochies) {
            vladController.addTamagotchiVlad(vlad);
            vladController.addTamagotchiVlad(vlad);
        }

        for  (int i = 0; i < tamagochies.size(); i++) {
            executorService.execute(() -> {
                vladController.feedAll();
                vladController.playAll();
                vladController.cleanAll();
                vladController.sleepAll();
            });
            executorService.execute(() -> vladController.removeTamagotchiVlad(programmer));
        }

        executorService.shutdown();

        try {
            while(!executorService.awaitTermination(20, TimeUnit.SECONDS)){}
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
