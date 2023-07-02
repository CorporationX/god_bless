package faang.school.godbless.threads.KingLand;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class Knight {
    @NonNull
    private String name;
    private List<Trial> trialList = new ArrayList<>();

    public void addTrial(Trial trial) {
        trialList.add(trial);
    }

    public void startTrials(ExecutorService service) {
        for (Trial trial : trialList) {
            service.execute(trial);
        }
    }
}
