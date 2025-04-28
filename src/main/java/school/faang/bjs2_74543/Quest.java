package school.faang.bjs2_74543;

import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class Quest {

    private final String name;
    private final int difficulty;
    private final int reward;

    public int doQuest() {
        try {
            TimeUnit.SECONDS.sleep(difficulty);
            return reward;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
