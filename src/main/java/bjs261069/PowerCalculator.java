package bjs261069;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PowerCalculator implements Runnable {
    public volatile List<Integer> powerSum;
    private Squad squad;

    public PowerCalculator(List<Integer> powerSum) {
        this.powerSum = powerSum;
    }

    @Override
    public void run() {
        powerSum.add(squad.calculateSquadPower(squad.getFighters()));
    }
}
