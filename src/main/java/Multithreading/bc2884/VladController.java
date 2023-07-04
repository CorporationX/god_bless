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
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                vladController.sleepAll();
                vladController.sleepAll();
                vladController.cleanAll();
                vladController.sleepAll();
                vladController.removeTamagochi(0);
                vladController.playAll();
                vladController.removeTamagochi(0);
                vladController.removeTamagochi(0);
                vladController.removeTamagochi(0);
                vladController.cleanAll();
                vladController.addTamagochi(new TamagotchiVlad(8));
                vladController.feedAll();
            });
        }
        executorService.shutdown();
    }

    public synchronized void addTamagochi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.add(tamagotchiVlad);
        System.out.println("Add one tamagochi " + tamagotchiVlad.getId());
    }

    public synchronized void removeTamagochi(int index) {
        if (!tamagotchiVladList.isEmpty()) {
            TamagotchiVlad vlad = tamagotchiVladList.get(index);
            tamagotchiVladList.remove(index);
            System.out.println(Thread.currentThread().getName() + " Delete " + vlad.getId());
        }
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
