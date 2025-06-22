package school.faang.bjs281213;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Squad {
    private String name;
    private List<Unit> listUnit = new ArrayList<>();

    public int calculatePowerSquad() {
        return listUnit.stream()
                .map(unit -> unit.getPower())
                .reduce(0, Integer::sum);
    }
}
