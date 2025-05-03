package school.faang.sprint_3.distributed_army;

import lombok.Getter;

@Getter
public class SquadPowerCalculator<T extends Fighter> extends Thread {
    private final Squad<T> squad;
    private int result;

    public SquadPowerCalculator(Squad<T> squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        result = squad.calculateSquadPower();
    }
}
