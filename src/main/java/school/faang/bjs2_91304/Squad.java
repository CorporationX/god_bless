package school.faang.bjs2_91304;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@AllArgsConstructor
public class Squad {
    private String name;
    private List<Fighter> fighters;

    public int calculateSquadPower() {

        int sum = fighters.stream()
                .mapToInt(Fighter::getPower).sum();
        log.info("{} сила: {}", name, sum);
        return sum;
    }
}
