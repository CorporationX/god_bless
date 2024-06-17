package faang.school.godbless.game.of.the.trons;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class Knight {
    private String name;
    private static List<Trial> trialList;

    public Knight(String name) {
        this.name = name;
        trialList = new ArrayList<>();
    }

    public void addTrialList(Trial trial) {
        trialList.add(trial);
    }

    public static void startTrial(ExecutorService executorService) {
        trialList
                .forEach(a -> executorService.submit(() -> a.run()));
        try {
            executorService.awaitTermination(new Random().nextInt(1, 5), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException("Trial was interrupted");
        }

        executorService.shutdown();
    }
}
