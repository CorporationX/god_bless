package school.faang.heroes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Squad {
    private final String name;
    private final List<Character> characters;

    public int calculateTotalPower() {
        return characters.stream()
                .mapToInt(Character::getPower)
                .sum();
    }
}
