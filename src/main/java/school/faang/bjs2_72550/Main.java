package school.faang.bjs2_72550;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Pasha",
                new ArrayList<>(List.of(
                        new Trial("Pasha", "Trial_1"),
                        new Trial("Pasha", "Trial_2"),
                        new Trial("Pasha", "Trial_3"),
                        new Trial("Pasha", "Trial_4")
                )));

        Knight knight2 = new Knight("Misha",
                new ArrayList<>(List.of(
                        new Trial("Misha", "Trial_1"),
                        new Trial("Misha", "Trial_2"),
                        new Trial("Misha", "Trial_3"),
                        new Trial("Misha", "Trial_4")
                )));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        KnightService knightService1 = new KnightService(knight1);
        KnightService knightService2 = new KnightService(knight2);

        knightService1.addTrial(new Trial("Pasha", "Trial_5"));
        knightService2.addTrial(new Trial("Misha", "Trial_5"));

        knightService1.startTrials(executorService);
        knightService2.startTrials(executorService);

        executorService.shutdown();
    }
}
