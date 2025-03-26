package tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;
}
