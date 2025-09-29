package bjs2_91297;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        var pigs = List.of(
                new Pig1Thread(),
                new Pig2Thread(),
                new Pig3Thread()
        );

        pigs.forEach(Thread::start);

        pigs.forEach(pig -> {
            try {
                pig.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Главный поток был прерван!");
            }
        });

        System.out.println("Игра завершена!");
    }
}