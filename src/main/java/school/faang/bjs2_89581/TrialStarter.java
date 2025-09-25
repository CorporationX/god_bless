package school.faang.bjs2_89581;

import java.util.concurrent.ExecutorService;

public class TrialStarter {

    public void startTrials(ExecutorService exec, Knight knight) {
        for (Trial t : knight.getTrials()) {
            exec.submit(t);
        }
    }
}