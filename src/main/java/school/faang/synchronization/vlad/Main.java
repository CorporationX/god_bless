package school.faang.synchronization.vlad;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<TamagotchiVlad> vlads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vlads.add(new TamagotchiVlad("Vlad " + i));
        }
        VladController vladController = new VladController(vlads);

        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(vladController::feedAll));
        threads.add(new Thread(vladController::playAll));
        threads.add(new Thread(vladController::cleanAll));
        threads.add(new Thread(vladController::sleepAll));

        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
