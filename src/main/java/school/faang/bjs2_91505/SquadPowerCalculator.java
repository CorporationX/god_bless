package school.faang.bjs2_91505;

import lombok.Getter;

public class SquadPowerCalculator extends Thread {
    private final Squad squad;
    @Getter
    private int result;

    public SquadPowerCalculator(Squad squad) {
        this.squad = squad;
    }

    public void run() {
        result = squad.calculateSquadPower();
    }
}
