package school.faang.task_61192;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Squad {
    private String name;
    private final List<Unit> units;


    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(init -> init.power)
                .sum();

    }
}
