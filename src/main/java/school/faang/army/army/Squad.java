package school.faang.army.army;

import lombok.RequiredArgsConstructor;
import school.faang.army.model.Division;

import java.util.List;

@RequiredArgsConstructor
public class Squad {
    private final List<Division> divisions;

    public int calculateSquadPower() {
        return divisions.stream().mapToInt(Division::getPower).sum();
    }
}