package school.faang.bjs2_82245;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quest {
    private String name;
    private DifficultyQuest difficulty;
    private int reward;
}
