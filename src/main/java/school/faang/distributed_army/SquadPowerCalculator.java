package school.faang.distributed_army;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SquadPowerCalculator<T extends Fighter> extends Thread {
    private final Squad<T> squad;
    private int result;

    @Override
    public void run() {
        result = squad.calculateSquadPower();
    }
}
