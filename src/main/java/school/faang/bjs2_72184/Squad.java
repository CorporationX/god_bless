package school.faang.bjs2_72184;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Squad {
    private String squadName;
    private List<Character> warriors;

    public Integer calculateSquadPower() {
        Integer squadPower = warriors.stream()
            .filter(Objects::nonNull)
            .mapToInt(Character::getPower)
            .sum();
        return squadPower;
    }
}
