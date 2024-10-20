package school.BJS2_36732;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<TamagotchiVlad> listOfVlads = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5 ; i++) {
            listOfVlads.add(new TamagotchiVlad("TamagotchiVlad" + i));
        }
        VladController vladController = new VladController(listOfVlads);

        threads.add(new Thread(vladController::playAll));
        threads.add(new Thread(vladController::sleepAll));
        threads.add(new Thread(vladController::feedAll));
        threads.add(new Thread(vladController::cleanAll));
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
