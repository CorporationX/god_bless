package school.faang.triwizard.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
@Slf4j
public class Task {
    private String name;
    private int difficulty;
    private double reward;

    public void performTask() {
        try {
            TimeUnit.SECONDS.sleep(difficulty * 2L);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}
