package school.faang.sprint3.squad;

import lombok.RequiredArgsConstructor;
import school.faang.sprint3.squad.warrior.Warrior;

import java.util.List;

@RequiredArgsConstructor
public class Squad {

    private final String squadName;
    private final List<Warrior> warriors;

    public Long calculateTotalPower() {
        return warriors.stream()
                .map(warrior -> warrior.getPower().longValue())
                .reduce(0L, Long::sum);
    }
}
