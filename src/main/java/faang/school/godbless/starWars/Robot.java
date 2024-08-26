package faang.school.godbless.starWars;

import lombok.Data;

@Data
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
    private int health;

    public Robot(String name, int attackPower, int defensePower, int health) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.health = health;
    }

    public synchronized void attack(Robot robot) {
        int attack = this.attackPower - robot.getDefensePower() / 2;
        robot.setHealth(robot.getHealth() - attack);
    }
}
