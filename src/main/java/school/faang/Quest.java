package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {
    private final String name;
    private int difficulty;
    private int reward;

}
