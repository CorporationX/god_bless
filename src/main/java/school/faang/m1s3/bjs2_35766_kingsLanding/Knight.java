package school.faang.m1s3.bjs2_35766_kingsLanding;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService service) {
        trials.forEach(service::execute);
    }
}
