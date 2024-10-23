package school.faang.fourthStream.BJS2_38299;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Robot {
    private final String name;
    private int attackPower;
    private int defensePower;

    public int getTotalPower(Robot robot) {
        return robot.getAttackPower() + robot.getDefensePower();
    }
}
