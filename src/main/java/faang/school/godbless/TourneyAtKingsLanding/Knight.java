package faang.school.godbless.TourneyAtKingsLanding;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Knight {
    @Getter
    private String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trial != null) {
            trials.add(trial);
        }
    }

    public void startTrials(ExecutorService executorService) {
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
    }
}
