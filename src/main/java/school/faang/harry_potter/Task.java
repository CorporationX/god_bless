package school.faang.harry_potter;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;
}
