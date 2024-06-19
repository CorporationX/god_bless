package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {

        System.out.println("Hello Almas!");

        List<Knight> knights = new ArrayList<>();
        Knight knight1 = new Knight("Vasya");
        knight1.addTrial("Defend innocent child");
        knight1.addTrial("Rescue beautiful princess");
        knights.add(knight1);

        Knight knight2 = new Knight("Petya");
        knight2.addTrial("Defense the Castle");
        knight2.addTrial("Ride wild horse");
        knights.add(knight2);

        startTrials(knights);
    }

    public static void startTrials(List<Knight> knights) {
        List<Trial> trials = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (Knight knight : knights) {
            trials.addAll(knight.trials);
        }
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
        executorService.shutdown();
    }
}