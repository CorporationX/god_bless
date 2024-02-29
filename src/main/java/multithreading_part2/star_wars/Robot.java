package multithreading_part2.star_wars;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
    public void attack(Robot robot){
        robot.setDefensePower(robot.getDefensePower() - this.attackPower);
    }
}
