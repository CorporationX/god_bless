package school.faang.split3.bjs2_81159;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad {
    private String name;
    private List<Warrior> squad;

    public int calculateSquadPower() {
        return squad.stream()
                .map(Warrior::getPower)
                .reduce(0, Integer::sum);
    }
}
