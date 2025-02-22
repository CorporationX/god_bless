package school.faang.naughtwoBJS261388;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import school.faang.naughtwoBJS261388.fighters.Fighter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Squad {

    private final String name;
    private List<Fighter> fighters;

    public int calculateSquadPower() {
        return fighters.stream()
                .map(Fighter::getPower)
                .reduce(0, Integer::sum);
    }
}
