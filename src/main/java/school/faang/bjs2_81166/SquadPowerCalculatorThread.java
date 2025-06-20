package school.faang.bjs2_81166;

import lombok.Getter;

@Getter
public class SquadPowerCalculatorThread extends Thread {
    private int totalPower;
    private final Squad<?> squad;

    public SquadPowerCalculatorThread(Squad<?> squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        this.totalPower = squad.calculateTotalPower();
    }
}