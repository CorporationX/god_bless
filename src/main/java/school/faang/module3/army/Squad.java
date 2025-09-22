package school.faang.module3.army;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Squad {
    private final String name;
    private final List<Character> squad;

    public Integer calculateTotalPower() {
        return squad.stream().map(Character::getPower).mapToInt(Integer::intValue).sum();
    }
}
