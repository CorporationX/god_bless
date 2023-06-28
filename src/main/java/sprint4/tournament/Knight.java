package sprint4.tournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Knight implements Runnable {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();
    private static final int SECONDS = 5;
    private static final Random RANDOM = new Random();

    @Override
    public void run() {
        startTrials();
    }

    private void startTrials() {
        for (Trial trial : trials) {
            System.out.printf("\nKnight %s began to pass the trial %s\n", name, trial.trialName());
            try {
                Thread.sleep((RANDOM.nextInt(SECONDS) + 1) * 1000);
            } catch (InterruptedException e) {
                System.out.println("Work interrupt");
            }

            if (RANDOM.nextBoolean()) {
                System.out.printf("\nKnight %s passed the trial %s\n", name, trial.trialName());
            } else {
                System.out.printf("\nKnight %s not passed the trial %s\n", name, trial.trialName());
            }
        }
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void addTrials(List<Trial> trials) {
        this.trials.addAll(trials);
    }
}
