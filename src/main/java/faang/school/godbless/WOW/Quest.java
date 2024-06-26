package faang.school.godbless.WOW;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
