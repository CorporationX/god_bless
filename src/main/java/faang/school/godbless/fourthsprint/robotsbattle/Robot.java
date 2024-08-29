package faang.school.godbless.fourthsprint.robotsbattle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Robot {
    @Getter
    private String name;
    private int attackPower;
    private int defensePower;

    public int getPower() {
        return attackPower + defensePower;
    }
}
