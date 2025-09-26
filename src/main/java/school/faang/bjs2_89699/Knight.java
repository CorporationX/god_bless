package school.faang.bjs2_89699;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Getter
public class Knight {
    public static final int THREAD_POOL_SIZE = 2;

    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (Trial trial : trials) {
            executor.submit(trial);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Выполнение испытаний затянулось.");
                executor.shutdownNow();
            }
            System.out.println("Испытания проведены успешно.");
        } catch (InterruptedException e) {
            System.out.println("Проведение испытаний прервано.");
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
