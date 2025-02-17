package bjs261069;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class PowerCalculator implements Runnable {
    public static volatile List<Integer> powerSum = new ArrayList<>();
    private Squad squad;

    @Override
    public void run() {
        powerSum.add(squad.calculateSquadPower(squad.getFighters()));
    }
}
