package faang.school.godbless.Async.WOW;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
