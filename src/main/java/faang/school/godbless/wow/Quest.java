package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Quest {

    private String name;
    private int difficulty;
    private int reward;
}
