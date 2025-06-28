package school.faang.bjs2_81243;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Getter
public class Squad<T extends Fighter> {
    private String squadName;
    private List<T> fighters = new ArrayList<>();

    public void addFighter(T fighter) {
        fighters.add(fighter);
    }

    public int calculateSquadPower() {
        if (fighters == null || fighters.isEmpty()) {
            log.info("В списке бойцов никого нет");
        }

        int sum = 0;
        for (T fighter : fighters) {
            sum += fighter.getPower();
        }
        return sum;
    }
}
