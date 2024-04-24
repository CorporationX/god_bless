package StarWarsArena;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
}
