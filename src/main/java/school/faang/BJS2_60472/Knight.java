package school.faang.BJS2_60472;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class Knight {
    private final String name;
    private List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        if (trials.isEmpty()) {
            throw new IllegalArgumentException("ведите испытание");
        }
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Knight firstKnight = new Knight("Ахилес");
        Knight secondKnight = new Knight("Персей");

        firstKnight.addTrial(new Trial(firstKnight.name, "убить скелетов"));
        firstKnight.addTrial(new Trial(firstKnight.name, "убить ведьму"));

        secondKnight.addTrial(new Trial(secondKnight.name, "прогнать призраков"));
        secondKnight.addTrial(new Trial(secondKnight.name, "победить Дракона"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        firstKnight.startTrials(executorService);

        secondKnight.startTrials(executorService);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}