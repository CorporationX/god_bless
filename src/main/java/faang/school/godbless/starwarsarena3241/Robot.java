package faang.school.godbless.starwarsarena3241;

import lombok.Getter;

@Getter
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
    private int totalPower;

    public Robot(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.totalPower = calculateTotalPower(attackPower, defensePower);
    }

    private int calculateTotalPower(int attackPower, int defensePower) {
        return (int) (Math.ceil(attackPower * 1.5) + Math.ceil(defensePower * 0.85));
    }
}
