package faang.school.godbless.sprint4.KingsLandingTournament.classes;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
@Getter
public class Knight {
    @NonNull
    private String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrial() {
        ExecutorService service = Executors.newFixedThreadPool(trials.size());
        for (Trial trial : trials) {
            service.submit(trial);
        }
        service.shutdown();
    }
}
