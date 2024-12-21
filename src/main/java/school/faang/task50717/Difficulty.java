package school.faang.task50717;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Difficulty {
    LOW(5),
    MIDDLE(10),
    HIGH(15);

    private final int seconds;
}
