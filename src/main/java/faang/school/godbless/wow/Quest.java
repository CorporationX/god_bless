package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}