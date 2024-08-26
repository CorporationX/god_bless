package faang.school.godbless;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public void addtrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrial() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        trials.stream()
                .map(trial -> (Runnable) trial::run)
                .forEach(executorService::submit);
        executorService.shutdown();
        }
}