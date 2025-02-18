package school.faang.task_61152;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class PowerCalculator extends Thread {
    private final Squad squad;
    private int power;

    public PowerCalculator(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        power = squad.calculateSquadPower();
    }
}
