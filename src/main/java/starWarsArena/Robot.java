package starWarsArena;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Robot {
    private String name;
    private int health;
    private int attackPower;
    private int defencePower;
}
