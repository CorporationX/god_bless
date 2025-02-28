package school.faang.task_61398;

import lombok.Getter;

import java.util.Objects;

public class SquadPowerCalculator extends Thread {
    private final Squad squad;
    @Getter
    private int power;

    public SquadPowerCalculator(Squad squad) {
        Objects.requireNonNull(squad, "Squad cant be null");
        this.squad = squad;
    }

    @Override
    public void run() {
        power = squad.calculateTotalPower();
    }
}
