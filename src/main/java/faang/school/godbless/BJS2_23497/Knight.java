package faang.school.godbless.BJS2_23497;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

class Knight {
    @Getter
    private final String name;
    private final List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        for (Trial trial : trials) {
            executorService.submit(() -> {
                try {
                    trial.run();
                } catch (Exception e) {
                    System.err.println("Что-то пошло не так, во время выполнения испытания: " + e.getMessage());
                }
            });
        }
    }
}
