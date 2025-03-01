package school.faang.task_BJS2_61262;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad<T extends Fighter> {
    private List<T> fighters;

    public int calculateSquadPower() {
        int powerOfSquad = 0;
        for (T fighter : fighters) {
            powerOfSquad += fighter.getPower();
        }
        return powerOfSquad;
    }
}
