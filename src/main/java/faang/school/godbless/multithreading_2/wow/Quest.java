package faang.school.godbless.multithreading_2.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Quest {
    private String name;
    @Getter
    private int difficulty;
    @Getter
    private int reward;
}
