package faang.school.godbless.starwars;

import lombok.Data;

@Data
public class Robot {

    private String name;
    private int attackPower;
    private int defencePower;
    private int hp = 100;

    public Robot(String name, int attackPower, int defencePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void attack(Robot robot) {
        robot.setHp(robot.getHp() - (getAttackPower() - robot.getDefencePower() / 3));
    }
}
