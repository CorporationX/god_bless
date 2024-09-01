package faang.school.godbless.tournament;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Knight implements Runnable {
    private final String name;
    private static final List<Trial> knightTrials = new ArrayList<>();

    @Override
    public void run() {
        startTrials();
    }

    public static void addTrials(List<Trial> trials) {
        knightTrials.addAll(trials);
    }

    private void startTrials() {
        knightTrials.forEach(t -> {
            try {
                System.out.printf("Knight '%s' starts trial '%s'%n", name, t.getTrialName());
                Thread.sleep(4000);
                System.out.printf("Finished trial '%s' by knight '%s'%n", t.getTrialName(), name);
            } catch(InterruptedException e) {
                System.err.printf("Trial '%s' by knight '%s' has been interrupted!%n", t.getTrialName(), name);
            }
        });
    }
}
