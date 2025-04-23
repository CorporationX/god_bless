package school.faang.bjs2_72550;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class KnightService {

    private final Knight knight;

    public void addTrial(Trial trial) {
        knight.trials().add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        knight.trials().forEach(executorService::execute);
    }
}
