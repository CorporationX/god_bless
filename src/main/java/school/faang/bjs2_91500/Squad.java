package school.faang.bjs2_91500;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Getter
public class Squad {
    private final List<Unit> unit;

    public int calculateSquadPower() {
        return unit.stream()
                .mapToInt(Unit::getPower).sum();
    }

}
