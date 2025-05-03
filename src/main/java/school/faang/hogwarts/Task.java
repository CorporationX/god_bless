package school.faang.hogwarts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Task {
    private final String name;
    private final DifficultyType difficulty;
    private final int reward;
}
