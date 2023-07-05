package faang.school.godbless.star_wars_arena;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
public class Robot {
    private String name;
    private int attackPower;
    private int defencePower;

    public void attack(Robot target) {
        target.setDefencePower(target.defencePower - this.attackPower);
    }
}
