package school.faang.task_61398;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Squad {
    private final String name;
    private final List<Character> fighters;

    public int calculateTotalPower() {
        Objects.requireNonNull(fighters, "Fighters cant be null");
        return fighters.stream().mapToInt(Character::getPower).sum();
    }
}
