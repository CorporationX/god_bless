package Multithreading.bc2127;

import java.util.ArrayList;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> pigs = new ArrayList<>();
        pigs.add(new Thread(new Pig1Thread("Ниф-Ниф", 1)));
        pigs.add(new Thread(new Pig2Thread("Наф-Наф", 2)));
        pigs.add(new Thread(new Pig3Thread("Нуф-Нуф", 3)));

        for (Thread thread : pigs) {
            thread.start();
        }
        pigs.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Игра завершена");
    }

}

