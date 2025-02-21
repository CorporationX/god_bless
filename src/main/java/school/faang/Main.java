package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TamagotchiVlad vlad1 = new TamagotchiVlad("Vlad 1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Vlad 2");

        List<Thread> threads = new ArrayList<>();
        VladController vladController = new VladController();
        vladController.addVlad(vlad1);
        vladController.addVlad(vlad2);

        threads.add(new Thread(vladController::feedAll));
        threads.add(new Thread(vladController::cleanAll));
        threads.add(new Thread(vladController::playAll));
        threads.add(new Thread(vladController::sleepAll));

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread join was interrupted.");
                throw new RuntimeException(e);
            }
        }
    }
}
