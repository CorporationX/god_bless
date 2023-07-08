package faang.school.godbless.tamagochi;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TamagotchiVlad vlad1 = new TamagotchiVlad("Vlad1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Vlad2");

        VladController controller = new VladController(List.of(vlad1, vlad2));

        Thread thread1 = new Thread(() -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });

        Thread thread2 = new Thread(() -> {
            controller.playAll();
            controller.playAll();
        });

        thread1.start();
        thread2.start();
    }
}
