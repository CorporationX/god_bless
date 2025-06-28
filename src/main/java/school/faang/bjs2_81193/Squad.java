package school.faang.bjs2_81193;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Squad {
    private String squadName;
    private List<Fighter> squad;

    public int calculateSquadPower() {
        return squad.stream().map(Fighter::getPower).reduce(0, Integer::sum);
    }
}
