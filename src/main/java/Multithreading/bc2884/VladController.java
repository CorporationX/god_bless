package Multithreading.bc2884;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Getter
public class VladController {
    public static List<TamagotchiVlad> tamagotchiVladList = new ArrayList<>();
    public static VladController vladController = new VladController();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            tamagotchiVladList.add(new TamagotchiVlad(i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            vladController.sleepAll();
            vladController.removeTamagochi(1);
            vladController.playAll();
            vladController.removeTamagochi(1);
            vladController.cleanAll();
            vladController.addTamagochi(new TamagotchiVlad(8));
            vladController.feedAll();
        });

        executorService.shutdown();
    }

    public void addTamagochi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.add(tamagotchiVlad);
    }

    public void removeTamagochi(int index) {
        tamagotchiVladList.remove(index);
        System.out.println("Delete " + index);
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVladList) {
            tamagotchiVlad.feed();
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVladList) {
            tamagotchiVlad.play();
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVladList) {
            tamagotchiVlad.clean();
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVladList) {
            tamagotchiVlad.sleep();
        }
    }
}
