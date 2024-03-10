package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
