package school.faang.potter;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class Task {
    private final String name;
    private final int difficulty;
    private final int reward;
}