package faang.school.godbless.multithreading.kings;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class Knight implements Runnable {

    private final String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        this.trials.add(trial);
    }

    @Override
    public void run() {
        for (Trial trial : trials) {
            log.info("{} takes on {}", this.name, trial.trialName());
            try {
                Thread.sleep(2000);
                log.info("{} completed {} successfully!", this.name, trial.trialName());
            } catch (InterruptedException e) {
                log.info("{} failed {}!", this.name, trial.trialName());
            }
        }
    }
}
