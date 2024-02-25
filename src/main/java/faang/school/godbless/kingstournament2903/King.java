package faang.school.godbless.kingstournament2903;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {

    public static void main(String[] args) throws InterruptedException {
        Knight brienne = new Knight("Brienne of Tarth");
        Knight jorah = new Knight("Jorah Mormont");
        ExecutorService trialsExecutor = Executors.newFixedThreadPool(2);
        createTrialsFor(brienne);
        createTrialsFor(jorah);
        List<Knight> knights = new ArrayList<>(List.of(brienne, jorah));
        Set<Trial> trials = new HashSet<>();

        knights.forEach(trial -> trials.addAll(trial.getTrials()));
        trials.forEach(trialsExecutor::execute);

        trialsExecutor.shutdown();
        trialsExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Brienne and Jorah made through all trials!");
    }

    private static void createTrialsFor(Knight knight) {
        knight.addTrial(new Trial(knight, "Search and rescue mission"));
        knight.addTrial(new Trial(knight, "Agility challenges"));
        knight.addTrial(new Trial(knight, "Archery competition"));
        knight.addTrial(new Trial(knight, "Tournament duel"));
    }
}
