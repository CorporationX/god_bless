package faang.school.godbless.starwars_arena;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Robot {
    private String name;
    private int attackPower;
    private int defencePower;

    public int calculatePower() {
        return attackPower + defencePower;
    }
}
