package faang.school.godbless.sprint3.BJS2_23457;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(@NonNull Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
            executorService.submit(() -> trials.forEach(Trial::run));
    }
}
