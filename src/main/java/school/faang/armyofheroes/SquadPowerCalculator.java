package school.faang.armyofheroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SquadPowerCalculator extends Thread {
    private final Squad squad;
    private int result;

    public SquadPowerCalculator(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        result = squad.calculateSquadPower();
    }
}
