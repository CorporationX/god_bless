package school.faang.sprint4.task_62777;

import java.util.concurrent.TimeUnit;

public record Task(String name, int difficulty, int reward) {

    public int start() {
        try {
            TimeUnit.SECONDS.sleep(difficulty);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return reward;
    }
}
