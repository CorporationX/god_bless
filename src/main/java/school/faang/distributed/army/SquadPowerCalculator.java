package school.faang.distributed.army;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SquadPowerCalculator extends Thread {
    private final Squad squad;
    private int result = 0;

    @Override
    public void run() {
        result = squad.calculateSquadPower();
    }
}
