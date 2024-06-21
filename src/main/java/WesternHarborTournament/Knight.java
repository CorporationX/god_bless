package WesternHarborTournament;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@Getter
public class Knight {
    private String name;
    private static final List<Trial> trials = new ArrayList<>();
    private static final int AMOUNT_TREAD = 2;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_TREAD);

    public static void addTrail(@NonNull Trial trial) {
        trials.add(trial);
    }

    public static void startTrail() {
        if (!trials.isEmpty()) {
            trials.forEach(executorService::submit);
            executorService.shutdown();
        } else {
            throw new NullPointerException("No available trials");
        }
    }
}
