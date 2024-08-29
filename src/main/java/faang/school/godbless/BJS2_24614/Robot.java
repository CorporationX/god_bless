package faang.school.godbless.BJS2_24614;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Robot {
    private final String name;
    private final int attackPower;
    private final int defensePower;

    public int getTotalPower() {
        return attackPower + defensePower;
    }
}
