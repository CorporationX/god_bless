package school.faang.heroes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Squad {
    private final String name;
    private final List<Warrior> fighters;

    public int calculateSquadPower() {
        return fighters.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}
