package faang.school.godbless.four;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Task {
    private String name;
    private int difficulty;
    @Getter
    private int reward;
}
