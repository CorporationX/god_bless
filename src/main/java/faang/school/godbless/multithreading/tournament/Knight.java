package faang.school.godbless.multithreading.tournament;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RequiredArgsConstructor
@Getter
public class Knight {
    @NonNull
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService threadPool) {
        synchronized (trials) {
            for (Trial trial : trials) {
                Future<?> future = threadPool.submit(trial);
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

}
