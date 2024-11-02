package school.faang.star.wars.arena;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;

    @Override
    public String toString() {
        return String.format("%s (Atk: %s Def: %s)", name, attackPower, defensePower);
    }
}
