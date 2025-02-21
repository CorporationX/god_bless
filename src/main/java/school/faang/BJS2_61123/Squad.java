package school.faang.BJS2_61123;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {

    private String typeName;
    private List<Fighter> fighters;

    public int calculateSquadPower() {
        return fighters.stream().mapToInt(Fighter::getPower).sum();
    }
}
