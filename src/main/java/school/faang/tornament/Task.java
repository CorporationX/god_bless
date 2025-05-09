package school.faang.tornament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;
}
