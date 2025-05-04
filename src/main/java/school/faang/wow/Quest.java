package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
