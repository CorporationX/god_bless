package school.faang.multithreading.synchron.tamagotchi;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Vlad1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Vlad2");

        controller.add(vlad1);
        controller.add(vlad2);

        Runnable tasks = () -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        };

        Thread thread1 = new Thread(tasks);
        Thread thread2 = new Thread(tasks);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
