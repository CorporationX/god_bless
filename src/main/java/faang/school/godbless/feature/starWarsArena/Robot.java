package faang.school.godbless.feature.starWarsArena;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Data
public class Robot {
    private final String name;
    private int attackPower;
    private int defencePower;

    public Robot attack(Robot robot) {
        try {
            while (this.getDefencePower() > 0 && robot.getDefencePower() > 0) {
                System.out.println(robot.getName() + " attacks " + this.getName());
                TimeUnit.SECONDS.sleep(1);
                this.defencePower -= robot.getAttackPower();
                System.out.println(this.getName() + " defence power: " + this.getDefencePower());

                System.out.println(this.getName() + " attacks " + robot.getName());
                TimeUnit.SECONDS.sleep(1);
                robot.defencePower -= this.getAttackPower();
                System.out.println(robot.getName() + " defence power: " + robot.getDefencePower());
                if (this.getDefencePower() <= 0) {
                    return robot;
                }
                if (robot.getDefencePower() <= 0) {
                    return this;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
