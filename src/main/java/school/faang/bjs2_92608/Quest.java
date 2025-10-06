package school.faang.bjs2_92608;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {
    private final String name;
    private final Difficult difficult;
    private final int reward;

    @AllArgsConstructor
    @Getter
    public enum Difficult {
        EASY(1),
        MEDIUM(3),
        HARD(5),
        PAIN(15);

        private final int difficultScore;
    }
}
