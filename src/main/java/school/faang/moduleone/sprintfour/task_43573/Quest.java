package school.faang.moduleone.sprintfour.task_43573;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public final class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;

    public void run() {
        try {
            Thread.sleep(difficulty * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
