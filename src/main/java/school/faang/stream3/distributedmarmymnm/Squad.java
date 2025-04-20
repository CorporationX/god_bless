package school.faang.stream3.distributedmarmymnm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Squad {
    private final String name;
    private final List<Unit> unitList;
    @Setter
    private int calculatedPower;

    public int calculateSquadPower() {
        return unitList.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }

}
