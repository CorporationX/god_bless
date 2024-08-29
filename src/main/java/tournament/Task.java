package tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Task {
    public static final long TIME_TO_COMPLETE = 1000L;
    private final String name;
    private final int difficulty;
    private final int reward;

    public int getFinalReward() {
        return reward * difficulty;
    }
}
