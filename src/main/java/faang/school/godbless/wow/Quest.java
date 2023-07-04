package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
