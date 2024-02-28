package faang.school.godbless.multithreading_async.star_wars;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot {
    private String name;
    private int health;
    private int attackPower;
    private int defensePower;

    public Robot(String name, int attackPower, int defensePower) {
        this.name = name;
        this.health = 100;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public static Robot battleRobots(Robot firstRobot, Robot secondRobot) {
        while (firstRobot.getHealth() > 0 && secondRobot.getHealth() > 0) {
            fight(firstRobot, secondRobot);
        }
        return (firstRobot.getHealth() > 0) ? firstRobot : secondRobot;
    }

    private static void fight(Robot firstRobot, Robot secondRobot){
        secondRobot.setHealth(secondRobot.getHealth() - (secondRobot.getDefensePower() - firstRobot.getAttackPower()));
        firstRobot.setHealth(firstRobot.getHealth() - (firstRobot.getDefensePower() - secondRobot.getAttackPower()));
    }
}
