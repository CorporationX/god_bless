package faang.school.godbless.tournament;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class Knight implements Runnable {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public void addTrial(@NonNull Trial trial) {
        trials.add(trial);
    }

    @Override
    public void run() {
        trials.forEach((trial) -> {
                    System.out.println(name + " is processing " + trial.getName());
                    try {
                        Thread.sleep(new Random().nextInt(1, 5) * 1000L);
                        System.out.println("The trial: " + trial.getName() + " has been passed successfully by " + name);
                    } catch (InterruptedException e) {
                        log.warn(name + " could not pass " + trial.getName());
                    }
                }
        );
    }
}

