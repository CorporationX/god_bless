package faang.school.godbless.multithreading.star_wars;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;

    public void attack(Robot robot) {
        robot.getDamage(attackPower);
    }

    private void getDamage(int damage) {
        defensePower -= damage;
    }
}
