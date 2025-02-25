package school.faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Superhero {
    private final String name;
    private final int strength;
    private final int agility;

    public int getPower() {
        return strength + agility;
    }
}
