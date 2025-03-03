package wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private int experience;
}
