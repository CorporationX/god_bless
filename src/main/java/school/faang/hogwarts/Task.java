package school.faang.hogwarts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Task {
    private String name;
    private DifficultyType difficulty;
    private int reward;
}
