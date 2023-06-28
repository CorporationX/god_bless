package faang.school.godbless.thread.tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Knight> knights = List.of(
                new Knight("Bronn"),
                new Knight("Torn")
        );

        for (Knight knight : knights) {
            knight.addTrial(new Trial(knight.getName(), "Гештех"));
            knight.addTrial(new Trial(knight.getName(), "Шарфреннен"));
        }

        Knight knight = knights.get(0);
        executorService.submit(knight.startTrials());

        Knight knight1 = knights.get(1);
        executorService.submit(knight1.startTrials());

        executorService.shutdown();
    }
}
