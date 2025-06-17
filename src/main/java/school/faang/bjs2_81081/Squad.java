package school.faang.bjs2_81081;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class Squad<T extends Unit> {
    private List<T> units = new ArrayList<>();

    public int calculateSquadPower() {
        int squadPower = units.stream().mapToInt(Unit::getPower).sum();
        log.info("Сила отряда: {}", squadPower);

        return squadPower;
    }
}
