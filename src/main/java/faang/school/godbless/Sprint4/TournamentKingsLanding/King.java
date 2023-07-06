package faang.school.godbless.Sprint4.TournamentKingsLanding;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) throws Exception {
        List<Knight> knights = List.of(new Knight("Biba"), new Knight("Boba"));

        for (int i = 0; i < 10; i++) {
            for (Knight knight : knights) {
                knight.addTrial(new Trial(knight.getName(), "Trial - " + (i + 1)));
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (Knight knight : knights) {
            executor.submit(knight::startTrials);
        }
        executor.shutdown();
    }
}
