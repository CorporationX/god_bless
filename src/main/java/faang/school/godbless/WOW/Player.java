package faang.school.godbless.WOW;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private final String name;
    private int level;
    private int experience;
}
