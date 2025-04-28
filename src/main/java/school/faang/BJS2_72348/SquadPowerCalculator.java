package school.faang.BJS2_72348;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class SquadPowerCalculator extends Thread {
    private int totalSquadPower;
    private Squad<?> squad;

    public SquadPowerCalculator(Squad<?> squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        totalSquadPower = squad.calculateSquadPower();
        log.info("Total squad '{}' power is {}", squad.getName(), totalSquadPower);
    }
}
