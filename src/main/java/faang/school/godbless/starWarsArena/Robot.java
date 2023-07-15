package faang.school.godbless.starWarsArena;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@AllArgsConstructor
@Data
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
}
