package faang.school.godbless.parallelism.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private final static Knight STARK = new Knight("Ned Stark");
    private final static Knight LANNESTER = new Knight("Jami Lannester");
    private final static List<Trial> TRIALS = List.of(
            new Trial("Ned Stark", "horse fight"),
            new Trial("Jami Lannester", "sword fight"),
            new Trial("Jami Lannester", "horse fight"),
            new Trial("Ned Stark", "archery"));
    private final static int POOL_SIZE = 2;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        List<Knight> knights = new ArrayList<>();

        knights.add(STARK);
        knights.add(LANNESTER);
        for (Trial trial : TRIALS) {
            STARK.addTrial(trial);
            LANNESTER.addTrial(trial);
        }

        for (Knight knight : knights) {
            knight.startTrials(executor);
        }
        executor.shutdown();
    }
}
