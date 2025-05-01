package school.faang.bjs2_72281;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Squad {
    private final String name;
    private List<AbstractWarrior> warriors;

    public int calculateSquadPower() {
        return warriors.stream().mapToInt(AbstractWarrior::getPower).sum();
    }
}
