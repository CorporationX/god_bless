package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private String name;
    private int level;
    private double experience;
}
