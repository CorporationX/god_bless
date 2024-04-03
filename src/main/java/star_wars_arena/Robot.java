package star_wars_arena;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
}
