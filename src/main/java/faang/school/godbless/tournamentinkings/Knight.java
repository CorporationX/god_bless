package faang.school.godbless.tournamentinkings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Getter
public class Knight implements Runnable {
    private final String name;
    private List<Trial> trials = new ArrayList<>();
    private Random random = new Random();

    public void addTrial(Trial trial) {
        this.trials.add(trial);
    }
    @Override
    public void run() {
        for(Trial trial : trials) {
            System.out.println("Trial " + trial.getTrialName() + " at the knight's " + name + " began");
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Trial " + trial.getTrialName() + " at the knight's " + name + " went well");
        }
    }
}

