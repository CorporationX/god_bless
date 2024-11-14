package school.faang.tournamentinkingslanding.main;

import school.faang.tournamentinkingslanding.maincode.Knight;
import school.faang.tournamentinkingslanding.maincode.Trial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 2;
    public static void main(String[] args) {
        Knight firstKnight = new Knight("Ахилес");
        Knight secondKnight = new Knight("Сын Пелея");

        firstKnight.addTrial(new Trial("Ахилес", "Огонь"));
        firstKnight.addTrial(new Trial("Ахилес", "Вода"));

        secondKnight.addTrial(new Trial("Сын Пелея", "Земля"));
        secondKnight.addTrial(new Trial("Сын Пелея", "Воздух"));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        executor.submit(firstKnight::startTrials);
        executor.submit(secondKnight::startTrials);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
