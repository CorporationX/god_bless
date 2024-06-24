package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_6_royal_harbor;

import java.util.ArrayList;
import java.util.List;

public record Knight(String name, List<Trial> trials) implements Runnable {

    public Knight(String name) {
        this(name, new ArrayList<>());
    }

    public void addTrial(String nameTrials) {
        trials.add(new Trial(name, nameTrials));
    }

    @Override
    public void run() {
        System.out.printf("%s приступил к испытаниям.\n", name);

        for (Trial trial : trials) {
            trial.run();
        }
    }
}
