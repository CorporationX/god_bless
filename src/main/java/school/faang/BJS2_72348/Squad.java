package school.faang.BJS2_72348;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Squad<T extends Fighter> {
    private String name;
    private List<T> fighters;

    public int calculateSquadPower() {
        return fighters.stream()
                .map(Fighter::getPower)
                .reduce(0, Integer::sum);
    }
}
