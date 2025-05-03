package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Quest {
    private final String name;
    private final DifficultyType difficulty;
    private final RewardType reward;
}
