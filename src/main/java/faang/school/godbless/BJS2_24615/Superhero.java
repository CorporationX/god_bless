package faang.school.godbless.BJS2_24615;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Superhero {
    @Getter
    private final String name;
    private final int strength;
    private final int agility;

    public int getTotalPower() {
        return strength + agility;
    }
}
