package faang.school.godbless.kings_haven;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {
        Knight knight1 = new Knight("knight1", List.of(new Trial("knight1", "trial 1_1"),
                new Trial("knight1", "trial 1_2")));
        Knight knight2 = new Knight("knight2", List.of(new Trial("knight2", "trial 2_3"),
                new Trial("knight1", "trial 2_4")));
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(knight1::startTrials);
        executorService.submit(knight2::startTrials);

        executorService.shutdown();
    }
}