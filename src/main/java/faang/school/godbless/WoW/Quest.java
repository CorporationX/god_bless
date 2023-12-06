package faang.school.godbless.WoW;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quest {
    private String name;
    private EDifficulty difficulty;
    private int reward;
}
