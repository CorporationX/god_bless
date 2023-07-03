package sprint5.starwars;

import lombok.Data;

@Data
public class Robot {
    private final String name;
    private final int attackPower;
    private final int defencePower;
    private int health;

    public Robot(String name, int attackPower, int defencePower, int health) {
        this.name = name;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.health = health;
    }

    public void attack(Robot robot) {
        int totalPower = attackPower - robot.defencePower / 10;
        robot.setHealth(robot.getHealth() - totalPower);
        if (robot.getHealth() < 0) {
            robot.setHealth(0);
        }
    }
}
