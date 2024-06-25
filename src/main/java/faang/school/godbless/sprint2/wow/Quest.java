package faang.school.godbless.sprint2.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Getter
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
