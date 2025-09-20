package school.faang.bjs2_90409;

import lombok.SneakyThrows;

import java.util.List;

public class Main {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    @SneakyThrows
    public static void main(String[] args) {
        TamagotchiVlad vlad1 = new TamagotchiVlad("Влад 1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Влад 2");
        TamagotchiVlad vlad3 = new TamagotchiVlad("Влад 3");
        TamagotchiVlad vlad4 = new TamagotchiVlad("Влад 4");
        TamagotchiVlad vlad5 = new TamagotchiVlad("Влад 5");
        TamagotchiVlad vlad6 = new TamagotchiVlad("Влад 6");
        List<TamagotchiVlad> vlads = List.of(vlad1, vlad2, vlad3, vlad4, vlad5, vlad6);
        VladController controller = new VladController(vlads);

        Thread thread1 = new Thread(() -> {
            try {
                controller.feedAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                controller.cleanAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                controller.playAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                controller.sleepAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
