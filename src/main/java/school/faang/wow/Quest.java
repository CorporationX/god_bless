package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
