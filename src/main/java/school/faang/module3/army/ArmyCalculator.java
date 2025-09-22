package school.faang.module3.army;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArmyCalculator extends Thread {

    private final Squad squad;
    @Getter
    private Integer totalPower;

    @Override
    public void run() {
        this.totalPower = squad.calculateTotalPower();
    }
}
