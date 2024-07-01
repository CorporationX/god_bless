package faang.school.godbless.sprint2.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Evgenii Malkov
 */
@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    @Setter
    private int experience;
}
