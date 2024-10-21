package school.faang.starWarsArena;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot {
    private final String name;
    private final int attackPower;
    private final int defensePower;

    public int sumPower() {
        return attackPower + defensePower;
    }
}